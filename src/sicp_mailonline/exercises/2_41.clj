;; Exercise 2.41
;; Write a procedure to find all ordered triples of distinct positive integers
;; i, j, and k less than or equal to a given integer n that sum to a given
;; integer s.

(ns sicp-mailonline.exercises.2-41
  (:require [sicp-mailonline.examples.2-2-3 :refer :all]))

(defn triples [n s]
  (let [triples (flatmap (fn [i] (flatmap (fn [j] (map (fn [k] (list i j k))
                                                       (enumerate-interval (inc j) n)))
                                          (enumerate-interval (inc i) n)))
                         (enumerate-interval 1 n))]
    (filter (fn [triple] (= s (accumulate + 0 triple)))
            triples)))
