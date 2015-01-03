(ns sicp-mailonline.exercises.1-12)

(defn cell [x y]
  (if (or (= 1 y) (= x y)) 1
    (+ (cell (dec x) (dec y)) (cell (dec x) y))))
