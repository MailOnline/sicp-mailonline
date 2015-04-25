;; Exercise 2.59
;; Implement the union-set operation for the unordered-list representation of
;; sets.

(ns sicp-mailonline.exercises.2-59
  (:require [sicp-mailonline.examples.2-3-3.unordered :refer [element-of-set?]]))

(defn union-set [set1 set2]
  (cond (empty? set1) set2
        (element-of-set? (first set1) set2) (recur (rest set1) set2)
        :else (recur (rest set1) (cons (first set1) set2))))
