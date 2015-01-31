;; Exercise 1.36

(ns sicp-mailonline.exercises.1-36)

(def ^:private ^:const tolerance 0.00001)

(defn fixed-point [f first-guess]
  (letfn [(close-enough? [v1 v2] (< (Math/abs (- v1 v2)) tolerance))
          (try-guess [guess]
            (let [next (f guess)]
              (println "guess was: " next)
              (if (close-enough? guess next)
                next
                (recur next))))]
    (println)
    (try-guess first-guess)))

(defn x-to-x []
  (fixed-point (fn [x] (/ (Math/log 1000) (Math/log x)))
               2.0))

(defn x-to-x-damped []
  (letfn [(average [a b] (/ (+ a b) 2))]
    (fixed-point (fn [x] (average x (/ (Math/log 1000) (Math/log x))))
                 2.0)))
