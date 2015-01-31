;; Exercise 2.8
;; Using reasoning analogous to Alyssa's, describe how the difference of two
;; intervals may be computed.  Define a corresponding substraction procedure,
;; called sub-interval.

(ns sicp-mailonline.exercises.2-8
  (:require [sicp-mailonline.exercises.2-7 :refer :all]))

(defn sub-interval [x y]
  (make-interval (- (lower-bound x) (upper-bound y))
                 (- (upper-bound x) (lower-bound y))))
