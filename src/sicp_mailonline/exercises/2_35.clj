;; Exercise 2.35
;; Redefine count-leaves fromsection 2.2.2 as an accumulation:
;;
;; (define (count-leaves t)
;;   (accummulate <??> <??> (map <??> <??>)))

(ns sicp-mailonline.exercises.2-35
  (:require [sicp-mailonline.examples.2-2-3 :refer :all]))

;; recursion within the map lambda
(defn count-leaves-a [t]
  (accumulate + 0 (map #(if (coll? %) (count-leaves-a %) 1)
                       t)))

;; convert the tree into a flat leaf sequence
(defn count-leaves-b [t]
  (accumulate + 0 (map (fn [leaf] 1)
                       (enumerate-tree t))))
