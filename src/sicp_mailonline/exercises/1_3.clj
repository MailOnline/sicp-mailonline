(ns sicp-mailonline.exercises.1-3)

(defn sum-of-squares [a b c]
  (cond
    (and (< a b) (< b c))
    (+ (* b b) (* c c))
    (and (< b c) (< c a))
    (+ (* c c) (* a a))
    :else
    (+ (* a a) (* b b))))
