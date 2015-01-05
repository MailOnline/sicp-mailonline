(ns sicp-mailonline.paragraphs.1-2-4)

(defn r-expt [b n]
  (if (= n 0)
    1
    (* b (r-expt b (- n 1)))))

(defn i-expt [b n]
  (if (zero? n)
    1
    (loop [acc b counter (dec n)]
      (if (zero? counter)
        acc
        (recur (* acc b) (dec counter))))))

(defn square [x] (* x x))

(defn f-expt [b n]
  (cond
    (= n 0) 1
    (even? n) (square (f-expt b (/ n 2)))
    :else (* b (f-expt b (- n 1)))))
