;; Exercise 2.48
;; A directed line segment in the plane can be represented as a pair of vectors
;; the vector running from the origin to the start-point of the segment, and the
;; vector running from the origin to the end-point of the segment.  Use your
;; vector representation from exercise 2.46 to define a representation for
;; segments with a constructor make-segment and selectors start-segment and
;; end-segment.

(ns sicp-mailonline.exercises.2-48
  (:require [sicp-mailonline.exercises.2-46 :refer :all]))

(defn make-segment [x1 y1, x2 y2]
  (list (make-vect x1 y1)
        (make-vect x2 y2)))

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (second segment))
