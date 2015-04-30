(ns sicp-mailonline.exercises.2-54)

(defn eq? [x y]
  (= x y))

(defn equal? [[x & xs :as xx] [y & ys :as yy]]
  (cond (every? empty? [xx yy]) true
        (eq? x y) (equal? xs ys)
        :else false))
