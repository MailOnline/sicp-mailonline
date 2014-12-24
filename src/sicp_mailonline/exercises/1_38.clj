;; Exercise 1.38
;; In 1737, the Swiss mathematician Leonhard Euler published a memoir De
;; Fractionibus Continuis, which included a continued fraction expansion
;; for e - 2, where e is the base of the natural logarithms.  In this
;; fraction, the Ni are all 1, and the Di are successively 1,2,1,1,4,1,1,
;; 6,1,1,8,....  Write a program that uses your cont-frac procedure from
;; exercise 1.37 to approximate e, based on Euler's expansion.

(ns sicp-mailonline.exercises.1-38
  (:require [sicp-mailonline.exercises.1-37 :refer [cont-frac-r]
                                            :rename {cont-frac-r cont-frac}]))

(defn approximate-e
  "Approximate e (2.71828...) using Euler's expansion"
  []
  (letfn [(d [i] (if (zero? (rem (inc i) 3))
                   (* 2 (quot (inc i) 3))
                   1))]
    (+ 2 (cont-frac (constantly 1.0) d, 10))))
