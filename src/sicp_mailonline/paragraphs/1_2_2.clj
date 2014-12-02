(ns sicp-mailonline.paragraphs.1-2-2)

(defn recursive-fibo [n]
  (case n
    0 0
    1 1
    (+ (recursive-fibo (- n 1)) (recursive-fibo (- n 2)))))

(defn iterative-fibo [n]
  (if (zero? n) 0
    (loop [a 1 b 0 cnt n]
      (if (zero? cnt)
        b
        (recur (+ a b) a (dec cnt))))))
