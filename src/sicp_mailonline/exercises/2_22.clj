(ns sicp-mailonline.exercises.2-22)

(defn square [x] (* x x))

(defn square-list1 [items]
  (loop [things items
         answer '()]
    (if (empty? things)
      answer
      (recur (rest things)
             (cons (square (first things)) answer)))))

;; in clojure in can't really cons a list into a scalar
;; the intent was to invert the sense of computation
;; and that can be obtained by reversing the input list
;;(defn square-list2 [items]
;;  (loop [things items
;;         answer '()]
;;    (if (empty? things)
;;      answer
;;      (recur (rest things)
;;             (cons answer (square (first things)))))))

(defn square-list2 [items]
  (loop [things (reverse items)
         answer '()]
    (if (empty? things)
      answer
      (recur (rest things)
             (cons (square (first things)) answer)))))

