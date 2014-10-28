(ns sicp-mailonline.exercises.1-4)

(defn a-plus-abs-b [a b]
  "Functions can be returned as values and invoked as such."
  ((if (> b 0) + -) a b))
