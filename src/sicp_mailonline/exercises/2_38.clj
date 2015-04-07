(ns sicp-mailonline.exercises.2-38)

(defn fold-right [f initial xs]
  (letfn [(iter [res others]
            (if (empty? others)
              res
              (f (first others) (iter res (rest others)))))]
    (iter initial xs)))

(defn fold-left [f initial xs]
  (loop [res initial
         others xs]
    (if (empty? others)
      res
      (recur (f res (first others)) (rest others)))))
