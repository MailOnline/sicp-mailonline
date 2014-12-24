;; Exercise 1.39
;; A continued fraction representation of the tangent function was published in
;; 1770 by the German mathematician J.H. Lambert:
;;   tan x = x / (1 - (x^2 / (3 - (x^2 / (5 - ...)))))
;; where x is in radians.  Define a procedure (tan-cf x k) that computes an
;; approximation to the tangent function based on Lambert's formula.
;; K specifies the number of terms to compute, as in exercise 1.37.

(ns sicp-mailonline.exercises.1-39
  (:require [sicp-mailonline.exercises.1-37 :refer [cont-frac-r]
                                            :rename {cont-frac-r cont-frac}]))

(defn tan-cf [x k]
  (letfn [(square [n] (* n n))
          (n [i] (if (= i 1) x (- (square x))))
          (d [i] (dec (* i 2.0)))]
    (cont-frac n d k)))
