(ns sicp-mailonline.exercises.1-11)

(defn frecur [n]
  (if (< n 3)
    n
    (+ (* 1 (frecur (dec n)))
       (* 2 (frecur (- n 2)))
       (* 3 (frecur (- n 3))))))

(defn fiter [n]
  (if (< n 3)
    n
    (loop [a 2 b 1 c 0 counter n]
      (if (= 0 counter)
        c
        (recur (+ a (* 2 b) (* 3 c)) a b (dec counter))))))
