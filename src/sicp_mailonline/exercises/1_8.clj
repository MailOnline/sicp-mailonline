(ns sicp-mailonline.exercises.1-8)

(def E 0.00001)

(defn good-enough? [guess x]
  (<= (Math/abs (- (* guess guess guess) x)) E))

(defn improve [guess x]
  (/  (+ (/ x (* guess guess)) (* 2 guess)) 3))

(defn cube-root-iter [guess x]
  (if (good-enough? guess x)
    guess
    (cube-root-iter (improve guess x) x)))

(defn cube-root [x]
  (let [init-guess 1.0]
    (cube-root-iter init-guess x)))
