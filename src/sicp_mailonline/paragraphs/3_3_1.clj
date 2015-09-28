(ns sicp-mailonline.paragraphs.3-3-1)

(defn set-car!! [x y]
  (cons y (rest x)))

(defn set-cdr!! [x y]
  (cons (first x) (cons y nil)))
