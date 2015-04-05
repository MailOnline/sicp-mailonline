(ns sicp-mailonline.exercises.2-17)

(defn last-pair [xs]
  (if (empty? (rest xs))
    (first xs)
    (recur (rest xs))))
