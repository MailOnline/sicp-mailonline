(ns sicp-mailonline.paragraphs.1-1-7)

(defn good-enough? [guess x]
  (< (Math/abs (- (* guess guess) x)) 0.001))

(defn average [x y]
  (/ (+ x y) 2.0))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))
