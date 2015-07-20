;; Exercise 2.84
;; Using the raise operation of exercise 2.83, modify the apply-generic
;; procedure so that it coerces its arguments to have the same type by the
;; method of successive raising, as discussed in this section.  You will need to
;; devise a way to test which of two types is higher in the tower.  Do this in a
;; manner that is "compatible" with the rest of the system and will not lead to
;; problems in adding new levels to the tower.

(ns sicp-mailonline.exercises.2-84
  (:require [sicp-mailonline.examples.2-1-1 :refer [numer denom]]
            [sicp-mailonline.exercises.2-83 :as ex2-83]))

;; data-directed configuration
(def ^:private op-table (atom {}))

(defn- put [op type item]
  (swap! op-table assoc-in [op type] item))

(defn- get [op type]
  (get-in @op-table [op type]))

;; addition packages
(defn- install-complex-addition-package []
  ;; for simplicity real-part & imag-part assume only rectangular complex representation
  (letfn [(real-part [z] (first (second z)))
          (imag-part [z] (second (second z)))]    
    (put 'add '(complex complex)
         (fn [x y] (ex2-83/make-complex-from-real-imag (+ (real-part x) (real-part y))
                                                       (+ (imag-part x) (imag-part y)))))))

(defn- install-real-addition-package []
  (put 'add '(real real)
       (fn [x y] (ex2-83/make-real (+ x y)))))

(defn- install-rational-addition-package []
  (put 'add '(rational rational)
       (fn [x y] (ex2-83/make-rational (+ (* (numer x) (denom y))
                                          (* (numer y) (denom x)))
                                       (* (denom x) (denom y))))))

(defn- install-integer-addition-package []
  (put 'add '(integer integer)
       (fn [x y] (ex2-83/make-integer (+ x y)))))

(defn install-arithmetic! []
  (swap! op-table merge (ex2-83/install-arithmetic!))
  (install-complex-addition-package)
  (install-real-addition-package)
  (install-rational-addition-package)
  (install-integer-addition-package))

;; generic operation
(defn- type-tag [datum]
  (if (coll? datum)
    (first datum)
    (throw (IllegalArgumentException.
            (str "Bad tagged datum -- TYPE-TAG " datum)))))

(defn- contents [datum]
  (if (coll? datum)
    (second datum)
    (throw (IllegalArgumentException.
            (str "Bad tagged datum -- CONTENTS " datum)))))

(defn- raise-to [x target-type]
  (letfn [(iter [arg]
            (let [source-type (type-tag arg)]
              (cond (= source-type target-type) arg
                    (get 'raise (list source-type)) (recur ((get 'raise (list source-type)) (contents arg)))
                    :else nil)))]
    (iter x)))

(defn- apply-generic [op & args]
  (let [type-tags (map type-tag args)
        proc (get op type-tags)
        throw-no-method (fn [] (throw (IllegalArgumentException.
                                       (str "No method for these types -- APPLY-GENERIC "
                                            (list op type-tags)))))]
    (if proc
      (apply proc (map contents args))
      (if (= (count args) 2)
        (let [arg1-type (first type-tags)
              arg2-type (second type-tags)]
          (if-let [arg2-as-arg1-type (raise-to (second args) arg1-type)]
            (recur op (list (first args) arg2-as-arg1-type))
            (if-let [arg1-as-arg2-type (raise-to (first args) arg2-type)]
              (recur op (list arg1-as-arg2-type (second args)))
              (throw-no-method))))
        (throw-no-method)))))

;; generic addition
(defn add [x y]
  (apply-generic 'add x y))
