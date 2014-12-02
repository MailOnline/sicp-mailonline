(ns sicp-mailonline.exercises.1-9)

(defn sum-with-inc
  "Adds a and b using the inc method"
  [a b]
  (if (= a 0)
    b
    (inc (+ (dec a) b))))

(defn sum-with-dec
  "Adds a and b using the dec method"
  [a b]
  (if (= a 0)
    b
    (+ (dec a) (inc b))))
