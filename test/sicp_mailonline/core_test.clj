(ns sicp-mailonline.core-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.core :refer :all]))

;; 1.1.7 Example: Square Roots by Newton's Method
(defn average [ & rest]
  (/ (apply + rest) (count rest)))

(defn abs [n]
  (if (< n 0)
    (- 0 n)
    n))

(defn square [n] (* n n))

(defn square-improve [guess x]
  (average guess (/ x guess)))

(defn square-good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (square-good-enough? guess x)
    (double guess)
    (sqrt-iter (square-improve guess x)
               x)))

(defn sqrt [x]
  (sqrt-iter 1 x))

(sqrt 4)

;;; Exercie 1.6 - Seems to hang in Clojure...
(defn new-if [pred true-expr false-expr]
  (cond (pred) true-expr
        :else false-expr))

;;; Exercise 1.8

(defn cube [n] (* n n n))

(defn cube-good-enough? [guess x]
  (< (abs (- (cube guess) x)) 0.001))

(defn cube-improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(defn cube-iter [guess x]
  (if (cube-good-enough? guess x)
    (double guess)
    (cube-iter (cube-improve guess x)
               x)))


(fact
  (= 1 1) => true)
