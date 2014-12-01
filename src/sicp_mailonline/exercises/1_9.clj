(ns sicp-mailonline.exercises.1-9)

(defn sum-recursive [a b]
  (if (zero? a)
    b
    (inc (sum-recursive (dec a) b))))

(defn sum-iterative [a b]
  (if (zero? a)
    b
    (recur (dec a) (inc b))))
