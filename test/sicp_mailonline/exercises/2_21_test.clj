;; Exercise 2.21

(ns sicp-mailonline.exercises.2-21-test
  (:require [sicp-mailonline.exercises.2-21 :refer :all]
            [clojure.test :refer :all]))

(defn- test-square-list [square-list]
  (testing "square list"
    (is (= '(1 4 9 16)
           (square-list (list 1 2 3 4)))))

  (testing "empty list"
    (is (= '()
           (square-list '())))))

(deftest exercise2-21
  (testing "using recursion"
    (test-square-list square-list-a))
  
  (testing "using map"
    (test-square-list square-list-b)))
