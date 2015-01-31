;; Exercise 2.10
;; Ben Bitdiddle, an expert systems programmer, looks over Alyssa's shoulder and
;; comments that it is not clear what it means to divide by an interval that
;; spans zero.  Modify Alyssa's code to check for this condition and to signal
;; an error if it occurs.

(ns sicp-mailonline.exercises.2-10
  (:require [sicp-mailonline.exercises.2-7 :refer [lower-bound upper-bound make-interval mul-interval]]))

(defn- spans-zero? [interval]
  (and (>= (upper-bound interval) 0)
       (<= (lower-bound interval) 0)))

(defn div-interval [x y]
  (when (spans-zero? y)
    (throw (IllegalArgumentException. "Divisor interval spans zero")))
  (mul-interval x (make-interval (/ 1M (upper-bound y))
                                 (/ 1M (lower-bound y)))))
