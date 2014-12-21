(ns sicp-mailonline.examples.1-3-3)

(def ^:private ^:const tolerance 0.00001)

(defn fixed-point [f first-guess]
  (letfn [(close-enough? [v1 v2] (< (Math/abs (- v1 v2)) tolerance))
          (try-guess [guess]
            (let [next (f guess)]
              (if (close-enough? guess next)
                next
                (recur next))))]
    (try-guess first-guess)))

(defn sqrt [x]
  (letfn [(average [a b] (/ (+ a b) 2.0))]    
    (fixed-point (fn [y] (average y (/ x y)))
                 1.0)))
