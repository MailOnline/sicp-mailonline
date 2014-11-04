(ns sicp-mailonline.paragraphs.chapter1.1-1-6
    (:refer-clojure :exclude [<= >=]))

(defn abs [x]
  (cond
   (> x 0) x
   (= x 0) 0
   (< x 0) (- x)))

(defn abs-2 [x]
  (cond
   (< x 0) (- x)
   :else x))

(defn abs-3 [x]
  (if (< x 0)
    (- x)
    x))

(defn <= [x y]
  (or (< x y) (= x y)))

(defn >= [x y]
  (or (> x y) (= x y)))
