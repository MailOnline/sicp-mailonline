(ns sicp-mailonline.paragraphs.1-2-5)

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (rem a b))))
