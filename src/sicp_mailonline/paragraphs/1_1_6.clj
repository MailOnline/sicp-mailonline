(ns sicp-mailonline.paragraphs.1-1-6)

(defn abs [x]
  (cond (< x 0) (- x)
        :else x))

(defn abs-if [x]
  (if (< x 0)
    (- x)
    x))

(defn le [a b]
  (or (< a b) (= a b)))

(defn ge [a b]
  (not (< a b)))
