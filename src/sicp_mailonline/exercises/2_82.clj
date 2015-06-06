;; Exercise 2.82
;; Show how to generalize apply-generic to handle coercion in the general case
;; of multiple arguments.  One strategy is to attempt to coerce all the
;; arguments to the type of the first argument, then to the type of the second
;; argument, and so on.  Give an example of a situation where this strategy (and
;; likewise the two argument version given above) is not sufficiently general.
;; (Hint: Consider the case where there are some suitable mixed-type operations
;; present in the table that will not be tried.)

(ns sicp-mailonline.exercises.2-82
  (:require [sicp-mailonline.examples.2-3-3.unordered :refer [element-of-set?
                                                              adjoin-set]]))

(declare type-tag contents)
(declare get get-coercion)

(defn- coerceable-to? [source-type target-type]
  (or (= source-type target-type)
      (get-coercion source-type target-type)))

(defn- all-coerceable-to? [source-types target-type]
  (cond (empty? source-types) true
        (coerceable-to? (first source-types) target-type)
          (recur (rest source-types) target-type)
        :else false))

(defn- coerceable-types [args]
  (letfn [(iter [candidates result]
            (cond (empty? candidates) result
                  (and (not (element-of-set? (first candidates) result));
                       (all-coerceable-to? (map type-tag args) (first candidates)))
                    (recur (rest candidates) (adjoin-set (first candidates) result))
                  :else (recur (rest candidates) result)))]
    (iter (map type-tag args) '())))

(defn- coerce-args [args target-type]
  (letfn [(coerce-arg [arg]
            (let [source-type (type-tag arg)]
              (if (= source-type target-type)
                arg
                (let [coercion (get-coercion source-type target-type)]
                  (coercion arg)))))]
    (map coerce-arg args)))

(defn apply-generic [op & args]
  (let [proc (get op (map type-tag args))]
    (if proc
      (apply proc (map contents args))
      (letfn [(iter [types]
                (if (empty? types)
                  (throw (IllegalArgumentException.
                          (str "No method for these types " (list op (map type-tag args)))))
                  (let [coerced-args (coerce-args args (first types))
                        proc (get op coerced-args)]
                    (if proc
                      (apply proc (map contents coerced-args))
                      (recur (rest types))))))]
        (iter (coerceable-types args))))))


;; This strategy is not sufficiently general because it takes no account of the
;; inheritance relationship between types.
;; Using figure 2.6, assume that a generic operation is defined with arguments
;; of type (polygon, polygon).  The triangle package provides an implementation
;; for (triangle, triangle).  If the procedure is invoked with
;; (isosceles-triangle, right-triangle) you would expect these types to be
;; coerced to the parent triangle type.  However, the strategy defined above will
;; look for coercion methods right-triangle->isosceles-triangle and
;; isosceles-triangle->right-triangle which do not (and cannot) exist.
;;
;;                 polygon
;;                    |
;;                 triangle
;;                   /  \
;; isosceles-triangle    right-triangle
