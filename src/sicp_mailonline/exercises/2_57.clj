;; Exercise 2.57
;; Extend the differentiation program to handle sums and products of arbitrary
;; numbers of (two or more) terms.  Then the last example above could be
;; expressed as
;;
;; (deriv '(* x y (+ x 3)) 'x)
;;
;; Try to do this by changing only the representation for sums and products,
;; without changing the deriv procedure at all.  For example, the addend of a
;; sum would be the first term, and the augend would be the sum of the rest of
;; the terms.

(ns sicp-mailonline.exercises.2-57
  (:require [sicp-mailonline.examples.2-3-2 :refer :all
             :exclude [augend multiplicand deriv]]))

(defn augend [e]
  (let [terms (drop 2 e)]
    (if (empty? (rest terms))
      (first terms)
      (cons '+ terms))))

(defn multiplicand [e]
  (let [terms (drop 2 e)]
    (if (empty? (rest terms))
      (first terms)
      (cons '* terms))))


;; the following is unchanged from exercise 2.56 and is simply here to support
;; the test examples
(defn- exponentiation? [e]
  (and (coll? e)
       (= (first e) '**)))

(defn- base [e]              ; first term
  (second e))

(defn- exponent [e]          ; second term
  (last e))

(defn- make-exponentiation [base exponent]
  (cond (=number? exponent 0) 1
        (=number? exponent 1) base
        :else (list '** base exponent)))

(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum
                        (make-product (multiplier exp)
                                      (deriv (multiplicand exp) var))
                        (make-product (deriv (multiplier exp) var)
                                      (multiplicand exp)))
        (exponentiation? exp) (make-product
                               (make-product (exponent exp)
                                             (make-exponentiation (base exp)
                                                                  (make-sum (exponent exp) -1)))
                               (deriv (base exp) var))
        :else (throw (IllegalArgumentException.
                      (format "unknown expression type [%s] -- DERIV" exp)))))
