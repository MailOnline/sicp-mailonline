(ns sicp-mailonline.paragraphs.1-3-3)

(defn square [x] (* x x))
(defn cube [x] (* x x x))

(defn p [x]
  (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (Math/abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

(defn poly [x]
"x^3 - 2x - 3 = 0"
  (- (* x x x) (* 2 x) 3))

(defn close-enough? [tolerance]
  (fn [x y] (< (Math/abs (- x y)) tolerance)))

(defn average [x y]
  (/ (+ x y) 2))

(defn search [f neg-point pos-point]
  (let [midpoint (average neg-point pos-point)]
    (if ((close-enough? 0.001) neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
        (cond (pos? test-value)
              (search f neg-point midpoint)
              (neg? test-value)
              (search f midpoint pos-point)
              :else midpoint)))))

(defn half-interval-method [f a b]
  (let [a-value (f a)
        b-value (f b)]
    (cond (and (neg? a-value) (pos? b-value))
          (search f a b)
          (and (neg? b-value) (pos? a-value))
          (search f b a)
          :else
          (throw (RuntimeException. (format "Values f(a) %s f(b) %s are not of opposite sign" a-value b-value))))))

(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (letfn [(iter [guess]
            (let [next (f guess)]
              (if ((close-enough? 0.00001) guess next)
                next
                (iter next))))]
    (iter first-guess)))

(defn sqrt [x]
  (fixed-point (fn [y] (/ x y)) 1.0))

(defn avg-damp-srqt [x]
  (fixed-point (fn [y] (average y (/ x y))) 1.0))
