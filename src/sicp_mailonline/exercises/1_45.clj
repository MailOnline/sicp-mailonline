;; Exercise 1.45
;; We saw in section 1.3.3 that attempting to compute square roots by naively
;; finding a fixed point of y |-> x/y does not converge, and that this can be
;; fixed by average damping.  The same method works for finding cube roots as
;; fixed points of the average-damped y |-> x/y^2.  Unfortunately, the process
;; does not work for fourth roots - a single average damp is not enough to make
;; a fixed-point search for y |-> x/y^3 converge.  On the other hand, if we
;; average damp twice (i.e. use the average damp of the average damp of
;; y |-> x/y^3) the fixed-point search does converge.
;; Do some experiments to determine how many average damps are required to
;; compute nth roots as a fixed-point search based upon repeated average
;; damping of y |-> x/y^(n-1).  Use this to implement a simple procedure for
;; computing nth roots using fixed-point, average-damp, and the repeated
;; procedure of exercise 1.43.  Assume that any arithmetic operations you need
;; are available as primitives.

(ns sicp-mailonline.exercises.1-45
  (:require [sicp-mailonline.examples.1-3-3 :refer [fixed-point]]
            [sicp-mailonline.examples.1-3-4 :refer [average-damp]]
            [sicp-mailonline.exercises.1-43 :refer [repeated]]))

(def ^:private ^:const initial-guess 1.0)

(defn nth-root [x n]
  (letfn [(root [y] (/ x (Math/pow y (dec n))))
          (log2 [n] (/ (Math/log n) (Math/log 2)))
          (damp-count [n] (max 1 (int (Math/floor (log2 n)))))]
    (fixed-point ((repeated average-damp (damp-count n)) root)
                 initial-guess)))
