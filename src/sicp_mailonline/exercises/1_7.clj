(ns sicp-mailonline.exercises.1-7
  (require [sicp-mailonline.paragraphs.1-1-7 :refer :all]))

(defn better-good-enough?
  [guess x]
  (let [delta (* guess 0.001)]
    (< (. Math abs (- (. Math pow guess 2) x)) delta)))
;(defn better-good-enough?
;  "The guess is good enough when it can't be improved"
;  [guess x]
;  (= guess (improve guess x)))

(defn better-sqrt-iter
  "Iterate closer to the square root of x"
  [guess x]
  (if (better-good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn better-sqrt
  "Use Newton's method to find the square root of x"
  [x]
  (better-sqrt-iter 1.0 x))
