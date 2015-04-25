;; Exercise 2.61

(ns sicp-mailonline.exercises.2-61-test
  (:require [sicp-mailonline.exercises.2-61 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-16
  (testing "adjoin-set"
    (is (= '(42)
           (adjoin-set 42 '())))

    (is (= '(42)
           (adjoin-set 42 '(42))))

    (is (= '(11 42)
           (adjoin-set 11 '(42))))

    (is (= '(42 99)
           (adjoin-set 99 '(42))))))
