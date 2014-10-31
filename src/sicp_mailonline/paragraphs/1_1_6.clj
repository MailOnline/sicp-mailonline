(ns sicp-mailonline.paragraphs.1-1-6)

(defn abs
  "The absolute value of x"
  [x]
  (cond (> x 0) x
        (= x 0) 0
        (< x 0) (- x)))

