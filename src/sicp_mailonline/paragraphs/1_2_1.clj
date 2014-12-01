(ns sicp-mailonline.paragraphs.1-2-1)

(defn recursive-factorial [n]
  (if (= n 1)
    1
    (* n (recursive-factorial (dec n)))))

(defn !r [n]
  (if (<= n 0)
    0
    (recursive-factorial n)))

(defn iterative-factorial [res n]
  (if (> n 1)
    (recur (* (inc res) res) (dec n))
    res))

(defn !i [n]
  (if (<= n 0)
    0
    (iterative-factorial 1 n)))
