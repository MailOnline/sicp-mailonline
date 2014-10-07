(ns sicp-mailonline.exercises.chapter1.1-3)

;; Define a procedure that takes three numbers as arguments and
;; returns the sum of the squares of the two larger numbers

(defn sum-two-largest [x y z]
  (->> (list x y z)
       (sort)
       (drop 1)
       (reduce +)))
