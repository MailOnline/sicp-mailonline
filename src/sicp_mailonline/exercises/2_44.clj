;; Exercise 2.44
;; Define the procedure up-split used by corner-split.  It is similar to
;; right-split, except that it switches the roles of below and beside.

(ns sicp-mailonline.exercises.2-44
  (:require [sicp-mailonline.examples.2-2-4 :refer [below beside]]))

(defn up-split [painter n]
  (if (zero? n)
    painter
    (let [smaller (up-split painter (dec n))]
      (below painter (beside smaller smaller)))))
