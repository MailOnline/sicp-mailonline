(ns sicp-mailonline.exercises.1-6
  (:require [sicp-mailonline.paragraphs.1-1-7 :as sqrt]))

(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn sqrt-iter [guess x]
  (new-if (sqrt/good-enough? guess x)
          guess
          (sqrt-iter (sqrt/improve guess x) x)))
