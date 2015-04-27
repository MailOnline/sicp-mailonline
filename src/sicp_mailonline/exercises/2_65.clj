;; Exercise 2.65
;; Use the result of exercises 2.63 and 2.64 to give O(n) implementations of
;; union-set and intersection-set for sets implemented as (balanced) binary
;; trees.

(ns sicp-mailonline.exercises.2-65
  (:require [sicp-mailonline.examples.2-3-3.ordered :refer [intersection-set]
                                                    :rename {intersection-set intersection-listset}]
            [sicp-mailonline.exercises.2-62 :refer [union-set]
                                            :rename {union-set union-listset}]))

(declare tree->list2)    ; O(n) exercise 2.63
(declare list->tree)     ; O(n) exercise 2.64

(defn union-set [set1 set2]
  (list->tree (union-listset (tree->list2 set1)
                             (tree->list2 set2))))

(defn intersection-set [set1 set2]
  (list->tree (intersection-listset (tree->list2 set1)
                                    (tree->list2 set2))))
