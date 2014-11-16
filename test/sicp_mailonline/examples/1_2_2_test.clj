;; 1.2.2 Tree Recursion

(ns sicp-mailonline.examples.1-2-2-test
  (:require [sicp-mailonline.examples.1-2-2 :refer :all]
            [clojure.test :refer :all]))

(deftest example1-2-2
  (testing "tree recursive Fibonacci"
    (let [fib rfib]
      (are [n x] (= x (fib n))
           0 0
           1 1
           2 1
           3 2
           4 3
           5 5
           6 8
           7 13
           8 21)))

  (testing "linear iterative Fibonacci"
    (let [fib ifib]
      (are [n x] (= x (fib n))
           0 0
           1 1
           2 1
           3 2
           4 3
           5 5
           6 8
           7 13
           8 21))))
