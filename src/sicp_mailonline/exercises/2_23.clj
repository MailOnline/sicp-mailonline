(ns sicp-mailonline.exercises.2-23)

(defn for-each [f xs]
  (if (empty? xs)
    nil
    (do
      (f (first xs))
      (recur f (rest xs)))))
