(ns sicp-mailonline.exercises.2-18
  (:refer-clojure :exclude [reverse]))

(defn reverse [xs]
  (loop [res '()
         more xs]
    (if (empty? more)
      res
      (recur (cons (first more) res) (rest more)))))
