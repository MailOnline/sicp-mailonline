;; Exercise 1.19

(ns sicp-mailonline.exercises.1-19-test
  (:require [sicp-mailonline.exercises.1-19 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise1-19
  (testing "fast Fibonacci"
    (are [n x] (= x (fib n))
          0  0
          1  1
          2  1
          3  2
          4  3
          5  5
          6  8
          7 13
          8 21
          9 34
         10 55)))

;;  n steps (invocations of fib-iter)
;;  1  2
;;  2  3
;;  4  4
;;  8  5
;; 16  6
;; 32  7
