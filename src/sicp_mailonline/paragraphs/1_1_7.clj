(ns sicp-mailonline.paragraphs.1-1-7)

(defn average
  "Find the mean of two numbers"
  [x y]
  (/ (+ x y) 2))

(defn improve
  "Improve a guess"
  [guess x]
  (average guess (/ x guess)))

(defn good-enough?
  [guess x]
  (< (. Math abs (- (. Math pow guess 2) x)) 0.001))

(defn sqrt-iter
  "Iterate closer to the square root of x"
  [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt
  "Use Newton's method to find the square root of x"
  [x]
  (sqrt-iter 1.0 x))
