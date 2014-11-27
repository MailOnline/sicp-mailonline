;; Exercise 1.19

(ns sicp-mailonline.exercises.1-19-test
  (:require [sicp-mailonline.exercises.1-19 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise1.19
  (testing "fast Fibonacci"
    (are [n x] (= x (fib n))
          1  0
          2  1
          3  1
          4  2
          5  3
          6  5
          7  8
          8 13
          9 21
         10 34)))

;;  n steps (invocations of fib-iter)
;;  1  2
;;  2  3
;;  4  4
;;  8  5
;; 16  6
;; 32  7
