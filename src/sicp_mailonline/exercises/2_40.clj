;; Exercise 2.40
;; Define a procedure unique-pairs that, given an integer n, generates the
;; sequence of pairs (i,j) with 1 <= j < i <= n.  Use unique pairs to
;; simplify the definition of prime-sum-pairs given above.

(ns sicp-mailonline.exercises.2-40
  (:require [sicp-mailonline.examples.1-2-6 :refer [prime?]]
            [sicp-mailonline.examples.2-2-3 :refer [enumerate-interval flatmap]]))

(defn unique-pairs [n]
  (letfn [(process-i [i]
            (map (fn [j] (list i j)) (enumerate-interval 1 (dec i))))]
    (flatmap process-i (enumerate-interval 1 n))))

(defn- sum [pair]
  (+ (first pair) (first (rest pair))))
  
(defn- make-pair-sum [pair]
  (list (first pair) (first (rest pair)) (sum pair)))

(defn- prime-sum? [pair]
  (prime? (sum pair)))

(defn prime-sum-pairs [n]
  (map make-pair-sum
       (filter prime-sum?
               (unique-pairs n))))
