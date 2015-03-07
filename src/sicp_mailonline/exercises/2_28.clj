;; Exercise 2.28
;; Write a procedure fringe that takes as argument a tree (represented as a list)
;; and returns a list whose elements are all the leaves of the tree arranged in
;; left-to-right order.  For example,
;;   (define x (list (list 1 2) (list 3 4)))
;;
;;   (fringe x)
;;   => (1 2 3 4)
;;
;;   (fringe (list x x))
;;   => (1 2 3 4 1 2 3 4)

(ns sicp-mailonline.exercises.2-28
  (:require [sicp-mailonline.examples.2-2-1 :refer [append]]))

;; dependency on append can be replaced with built-in clojure.core/concat
(defn fringe [tree]
  (cond (empty? tree) '()
        (coll? (first tree)) (append (fringe (first tree)) (fringe (rest tree)))
        :else (cons (first tree) (fringe (rest tree)))))
