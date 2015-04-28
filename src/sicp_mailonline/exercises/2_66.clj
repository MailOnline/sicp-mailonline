;; Exercise 2.66
;; Implement the lookup procedure for the case where the set of records is
;; structured as a binary tree, ordered by the numerical values of the keys.

(ns sicp-mailonline.exercises.2-66
  (:require [sicp-mailonline.examples.2-3-3.tree :refer :all]))

(declare key)

(defn lookup [given-key set-of-records]
  (cond (empty? set-of-records) nil
        (= given-key
           (key (entry set-of-records))) (entry set-of-records)
        (< given-key
           (key (entry set-of-records))) (recur given-key
                                                (left-branch set-of-records))
        (> given-key
           (key (entry set-of-records))) (recur given-key
                                                (right-branch (set-of-records)))))
