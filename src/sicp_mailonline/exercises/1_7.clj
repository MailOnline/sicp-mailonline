(ns sicp-mailonline.exercises.1-7)

(defn good-enough? [guess x]
  (< (Math/abs (- (* guess guess) x)) 0.001))

(defn average [x y]
  (/ (+ x y) 2.0))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (cond
    (good-enough? guess x) guess
    (= (improve guess x) (improve (improve guess x) x)) guess
    :else (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))
