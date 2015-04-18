;; Exercise 2.56
;; Show how to extend the basic differentiator to handle more kinds of
;; expressions.  For instance, implement the differentiation rule
;;
;; d(u^n)/dx = nu^(n-1)(du/dx)
;;
;; by adding a new clause to the deriv program and defining appropriate
;; procedures exponentiation?, base, exponent, and make-exponentiation.  (You
;; may use the symbol ** to denote exponentiation.)  Build in the rules that
;; anything raised to the power 0 is 1 and anything raised to the power 1 is the
;; thing itself.

(ns sicp-mailonline.exercises.2-56
  (:require [sicp-mailonline.examples.2-3-2 :refer :all :exclude [deriv]]))

(defn exponentiation? [e]
  (and (coll? e)
       (= (first e) '**)))

(defn base [e]              ; first term
  (second e))

(defn exponent [e]          ; second term
  (last e))

(defn make-exponentiation [base exponent]
  (cond (=number? exponent 0) 1
        (=number? exponent 1) base
        :else (list '** base exponent)))

;;; Differentiation reduction rules:
;;; dc/dx = 0 for c a constant or a variable different from x
;;; dx/dx = 1
;;; d(u+v)/dx = du/dx + dv/dx
;;; d(uv)/dx = u(dv/dx) + v(du/dx)
;;; d(u^n)/dx = nu^(n-1)(du/dx)
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
