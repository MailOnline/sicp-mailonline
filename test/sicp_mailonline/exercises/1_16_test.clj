;; Exercise 1.6

(ns sicp-mailonline.exercises.1-16-test
  (:require [sicp-mailonline.exercises.1-16 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise1-16
  (testing "exponentiation"
    (are [b n x] (= x (fast-expt b n))
          2 0 1
          2 1 2
          2 2 4
          2 3 8)))

;;  n  steps (invocations of iter)
;;  2    3
;;  4    4
;;  8    5
;; 16    6
;; 32    7
