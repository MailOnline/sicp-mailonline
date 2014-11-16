;; 1.2.2 Tree Recursion

(ns sicp-mailonline.examples.1-2-2-test
  (:require [sicp-mailonline.examples.1-2-2 :refer :all]
            [clojure.test :refer :all]))

(defn- test-fibonacci [f]
  (are [n x] (= x (f n))
       0 0
       1 1
       2 1
       3 2
       4 3
       5 5
       6 8
       7 13
       8 21))

(deftest example1-2-2
  (testing "tree recursive Fibonacci"
    (let [fib rfib]
      (test-fibonacci fib)))

  (testing "linear iterative Fibonacci"
    (let [fib ifib]
      (test-fibonacci fib)))

  (testing "counting change"
    (is (= 292
           (count-change 100)))))
