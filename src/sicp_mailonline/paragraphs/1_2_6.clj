(ns sicp-mailonline.paragraphs.1-2-6)

(defn square [n] (* n n))

(defn divides? [a b]
  (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) ;not sure about this bit
        n
        (divides? test-divisor n)
        test-divisor
        :else
        (find-divisor n (inc test-divisor))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))
