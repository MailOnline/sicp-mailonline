;; Exercise 1.6
;; Alyssa P. Hacker doesn't see why if needs to be provided as a special form.  
;; "Why can't I just define it as an ordinary procedure in terms of cond?" she asks.  
;; Alyssa's friend Eva Lu Ator claims this can indeed be done, and she defines a new version of if:
;;
;; (define (new-if predicate then-clause else-clause)
;;   (cond (predicate then-clause)
;;         (else else-clause)))
;;
;; Eva demonstrates the program for Alyssa:
;;
;; (new-if (= 2 3) 0 5)
;; 5
;;
;; (new-if (= 1 1) 0 5)
;; 0
;;
;; Delighted, Alyssa uses new-if to rewrite the square-root program:
;;
;; (define (sqrt-iter guess x)
;;   (new-if (good-enough? guess x)
;;           guess
;;           (sqrt-iter (improve guess x)
;;                      x)))
;; What happens when Alyssa attempts to use this to compute square
;; roots?  Explain.

(ns sicp-mailonline.exercises.1-6-test
  (:require [clojure.test :refer :all]))

(defn- new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn- average [x y]
  (/ (+ x y) 2))

(defn- improve [guess x]
  (average guess (/ x guess)))

(defn- square [x]
  (* x x))

(defn- good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn- sqrt-iter [guess x]
  (new-if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn- sqrt [x]
  (sqrt-iter 1.0 x))

(deftest exercise1-6
  (testing "both the consequent and alternative expressions are evaluated"
    (is (thrown? StackOverflowError (sqrt 9)))))

;; =========================================
;; if special form short-circuits evaluation
;; =========================================
;; if is implemented as a special form to facilitate short-circuiting the evaluation of its sub-expressions.
;; As new-if is a procedure, not a special form, the expression will be evaluated using applicative order evaluation, resulting in the evaluation of both the consequent and alternative expressions.
;; In the case of sqrt-iter, evaluation of the alternative expression results in a recursive call, which sets up an infinite loop.
;; In the implementation above, the recursive call does not benefit from tail-call optimisation, and so this loop will trigger a StackOverflowError.
