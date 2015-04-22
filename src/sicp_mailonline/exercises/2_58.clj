;; Exercise 2.58
;; Suppose we want to modify the differentiation program so that it works with
;; ordinary mathematical notation, in which + and * are infix rather than prefix
;; operators.  Since the differentiation program is defined in terms of abstract
;; data, we can modify it to work with different representations of expressions
;; solely by changing the predicates, selectors, and constructors that define
;; the representation of the algebraic expressions on which the differentiator
;; is to operate.
;;
;; a.  Show how to do this in order to differentiate algebraic expressions
;; presented in infix form, such as (x + (3 * (x + (y + 2)))).  To simplify the
;; task, assume that + and * always take two arguments and that expressions are
;; fully parenthesized.
;; b.  The problem becomes substantially harder if we allow standard algebraic
;; notation, such as (x + 3 * (x + y + 2)), which drops unnecessary parentheses
;; and assumes that multiplication is done before addition.  Can you design
;; appropriate predicates, selectors, and constructors for this notation such
;; that our derivative program still works?

(ns sicp-mailonline.exercises.2-58
  (:require [sicp-mailonline.examples.2-3-2 :refer [variable? same-variable?
                                                    augend =number? multiplicand]]))

(defn- has-operator? [e operator]
  (and (coll? e)
       (= (second e) operator)))

(defn- sum? [e]
  (has-operator? e '+))

(defn- addend [e]
  (first e)) 

(defn- make-operation [operator x y]
  (list x operator y))

(defn- make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (make-operation '+ a1 a2)))

(defn- product? [e]
  (has-operator? e '*))

(defn- multiplier [e]
  (first e))

(defn- make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (make-operation '* m1 m2)))

;; adding exponentiation support from exercise 2.56
(defn- exponentiation? [e]
  (has-operator? e '**))

(defn- base [e]
  (first e))

(defn- exponent [e]
  (last e))

(defn make-exponentiation [base exponent]
  (cond (=number? exponent 0) 1
        (=number? exponent 1) base
        (and (number? base) (number? exponent)) (Math/pow base exponent)
        :else (make-operation '** base exponent)))


;; Note that the implementation of deriv is unaffected by the
;; change of representation - the following is that of exercise 2.56
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
