;; Exercise 2.17
;; Define a procedure last-pair that returns the list that contains only the
;; last element of a given (nonempty) list:
;;
;;  (last-pair (list 23 72 149 34))
;;  => (34)

(ns sicp-mailonline.exercises.2-17)

(defn last-pair [values]
  (if (empty? (rest values))
    values
    (recur (rest values))))
