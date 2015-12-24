(ns sicp-mailonline.gcd)

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))