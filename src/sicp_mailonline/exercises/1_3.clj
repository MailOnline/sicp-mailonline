(ns sicp-mailonline.exercises.1-3
  (:require [sicp-mailonline.paragraphs.1-1-4 :refer :all]))

(defn sum-square-two-larger
  "Sums the squares of the two larger arguments"
  [a b c]
  (apply sum-of-squares
         (rest (sort [a b c]))))

