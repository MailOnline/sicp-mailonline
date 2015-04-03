;; Exercise 2.50
;; Define the transformation flip-horiz, which flips painters horizontally, and
;; transformations that rotate painters counterclockwise by 180 degrees and 270
;; degrees.

(ns sicp-mailonline.exercises.2-50
  (:require [sicp-mailonline.examples.2-4-4]))

(defn flip-horiz [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))

(defn rotate180 [painter]
  (transform-painter painter
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 0.0)))

(defn rotate270 [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0))
