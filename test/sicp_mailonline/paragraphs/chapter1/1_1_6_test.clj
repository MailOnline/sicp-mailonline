(ns sicp-mailonline.paragraphs.chapter1.1-1-6-test
  (:refer-clojure :exclude [<= >=])
  (:require [sicp-mailonline.paragraphs.chapter1.1-1-6 :refer :all]
            [clojure.test :refer :all]))

(deftest test-abs-1
  (testing "absolute value of 7 is 7"
    (is (= (abs-1 7) 7)))
  (testing "absolute value of 0 is 0"
    (is (= (abs-1 0) 0)))
  (testing "absolute value of -7 is 7"
    (is (= (abs-1 -7) 7))))

(deftest test-abs-2
  (testing "absolute value of 7 is 7"
    (is (= (abs-2 7) 7)))
  (testing "absolute value of 0 is 0"
    (is (= (abs-2 0) 0)))
  (testing "absolute value of -7 is 7"
    (is (= (abs-2 -7) 7))))

(deftest test-abs-3
  (testing "absolute value of 7 is 7"
    (is (= (abs-3 7) 7)))
  (testing "absolute value of 0 is 0"
    (is (= (abs-3 0) 0)))
  (testing "absolute value of -7 is 7"
    (is (= (abs-3 -7) 7))))

(deftest test-less-than-or-equal-to
  (testing "<= 1 5 is true"
    (is (<= 1 5)))
  (testing "<= 4 4 is true"
    (is (<= 4 4)))
  (testing "<= 10 4 is false"
    (is (not (<= 10 4)))))

(deftest test-greater-than-or-equal-to
  (testing ">= 9 8 is true"
    (is (>= 9 8)))
  (testing ">= 8 8 is true"
    (is (>= 8 8) true))
  (testing ">= 1 2 is false"
    (is (not (>= 1 2)))))
