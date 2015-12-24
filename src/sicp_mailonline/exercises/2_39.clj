(ns sicp-mailonline.exercises.2-39
  (:require [sicp-mailonline.exercises.2-38 :refer [fold-left fold-right]]))

(defn reverse-1 [sequence]
  (fold-right 
    (fn [elem acc] (concat acc (list elem))) nil sequence))

(defn reverse-2 [sequence]
  (fold-left 
    (fn [acc elem] (cons elem acc)) nil sequence))

