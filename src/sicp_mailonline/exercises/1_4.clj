(ns sicp-mailonline.exercises.1-4)

(defn a-plus-abs-b
  "Adds the absolute value of b to a"
  [a, b]
  ((if (> b 0) + -) a b))
