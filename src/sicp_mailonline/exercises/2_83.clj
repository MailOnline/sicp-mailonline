;; Exercise 2.83
;; Suppose you are designing a generic arithmetic system for dealing with the
;; tower of types shown in figure 2.25: integer, rational, real, complex.  For
;; each type (except complex), design a procedure that raises objects of that
;; type one level in the tower.  Show how to install a generic raise operation
;; that will work for each type (except complex).
;;
;; figure 2.25:
;;              complex
;;                 |
;;               real
;;                 |
;;             rational
;;                 |
;;              integer

(ns sicp-mailonline.exercises.2-83
  (:require [sicp-mailonline.examples.2-1-1 :refer [make-rat numer denom]]))

(defn- attach-tag [type-tag contents]
  (list type-tag contents))

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

;; data-directed configuration
(def ^:private op-table (atom {}))

(defn- put [op type item]
  (swap! op-table assoc-in [op type] item))

(defn- get [op type]
  (get-in @op-table [op type]))

;; complex numbers
(defn make-complex-from-real-imag [x y]
  ((get 'make-from-real-imag '(complex)) x y))

(defn- install-complex-rectangular-package []
  (letfn [(tag [x]
            (attach-tag 'rectangular x))
          (make-from-real-imag [x y]
            (list x y))]
    (put 'make-from-real-imag '(rectangular)
         (fn [x y] (tag (make-from-real-imag x y))))))

(defn- install-complex-package []
  (letfn [(tag [x]
            (attach-tag 'complex x))
          (make-from-real-imag [x y]
            ((get 'make-from-real-imag '(rectangular)) x y))]
    (put 'make-from-real-imag '(complex)
         (fn [x y] (tag (make-from-real-imag x y))))))

;; real numbers
(defn make-real [x]
  ((get 'make '(real)) x))

(defn- install-real-package []
  (letfn [(tag [x]
            (attach-tag 'real x))]
    (put 'make '(real)
         (fn [x] (tag x)))
    (put 'raise '(real)
         (fn [x] (make-complex-from-real-imag x 0)))))

;; rational numbers
(defn make-rational [numerator denominator]
  ((get 'make '(rational)) numerator denominator))

(defn- install-rational-package []
  (letfn [(tag [x]
            (attach-tag 'rational x))]
    (put 'make '(rational)
         (fn [n d] (tag (make-rat n d))))
    (put 'raise '(rational)
         ;; force floating point with double to avoid built-in rational type
         (fn [x] (make-real (/ (double (numer x))
                               (denom x)))))))

;; integer numbers
(defn make-integer [x]
  ((get 'make '(integer)) (int x)))

(defn- install-integer-package []
  (letfn [(tag [x]
            (attach-tag 'integer x))]    
    (put 'make '(integer)
         (fn [x] (tag x)))
    (put 'raise '(integer)
         (fn [x] (make-rational x 1)))))

(defn install-arithmetic! []
  (install-complex-rectangular-package)
  (install-complex-package)
  (install-real-package)
  (install-rational-package)
  (install-integer-package)
  @op-table)

;; generic operation
(defn- apply-generic [op & args]
  (let [type-tags (map type-tag args)
        proc (get op type-tags)]
    (if proc
      (apply proc (map contents args))
      (throw (IllegalArgumentException.
              (str "No method for these types -- APPLY-GENERIC " (list op type-tags)))))))

(defn raise [number]
  (apply-generic 'raise number))
