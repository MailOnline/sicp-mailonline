(ns sicp-mailonline.exercises.1-7
  (require [sicp-mailonline.paragraphs.1-1-7 :refer :all]))

(defn better-good-enough?
  [guess last-guess]
  (let [delta (* guess 0.00000000000001)]
    (< (. Math abs (- last-guess guess)) delta)))

(defn better-sqrt-iter
  "Iterate closer to the square root of x"
  [guess last-guess x]
  (if (better-good-enough? last-guess guess)
    guess
    (better-sqrt-iter (improve guess x) guess x)))

(defn better-sqrt
  "Use Newton's method to find the square root of x"
  [x]
  (better-sqrt-iter 1.0 0.0 x))
