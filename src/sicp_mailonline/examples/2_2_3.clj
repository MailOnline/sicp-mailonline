;; 2.2.3 Sequences as Conventional Interfaces

(ns sicp-mailonline.examples.2-2-3
  (:require [sicp-mailonline.examples.2-2-1 :refer [append]]))

(defn filter [predicate sequence]
  (cond (empty? sequence) '()
        (predicate (first sequence)) (cons (first sequence)
                                           (filter predicate (rest sequence)))
        :else (recur predicate (rest sequence))))

(defn accumulate [op initial sequence]
  (if (empty? sequence)
    initial
    (op (first sequence)
        (accumulate op initial (rest sequence)))))

(defn enumerate-interval [low high]
  (if (> low high)
    '()
    (cons low
          (enumerate-interval (inc low) high))))

(defn enumerate-tree [tree]
  (cond (not (coll? tree)) (list tree)
        (empty? tree) '()
        :else (append (enumerate-tree (first tree))
                      (enumerate-tree (rest tree)))))

(defn flatmap [proc seq]
  (accumulate append '() (map proc seq)))
