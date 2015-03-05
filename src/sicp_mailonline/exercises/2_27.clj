;; Exercise 2.27
;; Modify your reverse procedure of exercise 2.18 to produce a deep-reverse
;; procedure that takes a list as argument and returns as its value the list
;; with its elements reversed and will all sublists deep-reversed as well.
;; For example,
;;   (define x (list (list 1 2) (list 3 4)))
;;
;;   x
;;   => ((1 2) (3 4))
;;
;;   (reverse x)
;;   => ((3 4) (1 2))
;;
;;   (deep-reverse x)
;;   => ((4 3) (2 1))

(ns sicp-mailonline.exercises.2-27)

(defn deep-reverse-a [values]
  (letfn [(reverse-into [in out]
             (cond (empty? in) out
                   (coll? (first in)) (recur (rest in) (cons (reverse-into (first in) '()) out))
                   :else (recur (rest in) (cons (first in) out))))]
    (reverse-into values '())))

;; a more idiomatic Clojure solution (assuming we cannot use clojure.core/reverse)
(defn deep-reverse-b [values]
  (reduce (fn [acc x] (conj acc (if (coll? x) (deep-reverse-b x) x))) '() values))
