(ns sicp-mailonline.exercises.chapter1.1-4-test
  (:require [sicp-mailonline.exercises.chapter1.1-4 :refer :all]
            [clojure.test :refer :all]))

(deftest test-a-plus-abs-b
  (testing "Should sum a and b when both positive numbers"
    (is (= (a-plus-abs-b 5 10) 15)))
  (testing "Should sum a and b when a is positive and b is negative"
    (is (= (a-plus-abs-b 5 -10) 15)))
  (testing "Should sum a and b when a is negative and b is positive"
    (is (= (a-plus-abs-b -2 5) 3)))
  (testing "Should sum a and b when both negative numbers"
    (is (= (a-plus-abs-b -5 -5) 0))))
