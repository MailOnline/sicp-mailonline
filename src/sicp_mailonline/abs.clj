
(ns sicp-mailonline.abs)

(defn abs [x]
  (if (< x 0)
    (- 0 x)
    x))
