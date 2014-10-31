(ns sicp-mailonline.paragraphs.1-1-4)

(defn square
  "Raises x to the power of 2"
  [x]
  (* x x))

(defn sum-of-squares
  "Sums 2 squares"
  [x y]
  (+ (square x) (square y)))

(defn f
  "(a+1)^2 + (2a)^2"
  [a]
  (sum-of-squares (+ a 1) (* a 2)))

