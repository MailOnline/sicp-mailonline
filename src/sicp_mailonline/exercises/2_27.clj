(ns sicp-mailonline.exercises.2-27)

(defn visit [t]
  (cond
    (not (seq? t)) t
    (empty? t) t
    :else (cons (visit (first t)) (visit (rest t)))))

(defn deep-reverse [t]
  (loop [res '()
         [head & others :as more] t]
    (if (empty? more)
      res
      (recur (cons
               (if (seq? head) (deep-reverse head) head)
               res) others))))
