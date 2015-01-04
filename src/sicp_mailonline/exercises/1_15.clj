(ns sicp-mailonline.exercises.1-15)

(declare ^:dynamic logger)

(defn- log [info]
  (when (swap! logger conj info)))

(defn cube [x] (* x x x))

(defn p [x]
  (log x)
  (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (Math/abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))
