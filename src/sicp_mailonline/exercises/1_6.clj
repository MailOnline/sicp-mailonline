(ns sicp-mailonline.exercises.1-6
  (require [sicp-mailonline.paragraphs.1-1-7 :refer :all]))

(defn new-if
  "Eva Lu Ator's redefinition of if"
  [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn new-sqrt-iter
  "Alyssa P Hacker's new sqrt-iter fn"
  [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x)
                     x)))


