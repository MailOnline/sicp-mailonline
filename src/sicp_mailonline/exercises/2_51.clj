;; Exercise 2.51
;; Define the below operation for painters.  Below takes two painters as
;; arguments.  The resulting painter, given a frame, draws with the first
;; painter in the bottom of the frame and with the second painter in the
;; top.  Define below in two different ways - first by writing a procedure
;; that is analogous to the beside procedure given above, and again in
;; terms of beside and suitable rotation operations (from exercise 2.50).

(ns sicp-mailonline.exercises.2-51
  (:require [sicp-mailonline.examples.2-2-4 :refer [transform-painter beside rotate90]]
            [sicp-mailonline.exercises.2-46 :refer [make-vect]]
            [sicp-mailonline.exercises.2-50 :refer [rotate270]]))

;; analogous to beside
(defn below-a [bottom-painter top-painter]
  (let [split-point (make-vect 0.0 0.5)
        paint-top (transform-painter top-painter
                                     split-point
                                     (make-vect 1.0 0.5)
                                     (make-vect 0.0 1.0))
        paint-bottom (transform-painter bottom-painter
                                        (make-vect 0.0 0.0)
                                        (make-vect 1.0 0.0)
                                        split-point)]
    (fn [frame]
      (paint-top frame)
      (paint-bottom frame))))

;; in terms of beside and suitable rotation operations
(defn below-b [bottom-painter top-painter]
  (rotate90 (beside (rotate270 bottom-painter)
                    (rotate270 top-painter))))
