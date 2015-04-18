; 
; Exercise 2.19
;

(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest test-first-denomination
  (testing "First us coin is a half-dollar"
    (is (= (first-denomination us-coins) 50)))
  (testing "First uk coin is one pound"
    (is (= (first-denomination uk-coins) 100))))

(deftest test-except-first-denomination
  (testing "us coins except the half-dollar"
    (is (= (except-first-denomination us-coins) '(25 10 5 1)))))

(deftest test-no-more? 
  (testing "no more for empty list"
    (is (no-more? '()))
  (testing "no more for list with an elements")  
    (is (not (no-more? '(1))))))

(deftest test-count-change
  (testing "Ways to make a dollar are correct"
    (is (= (count-change-us 100) 292))))

(deftest test-count-change-alt-order
  (testing "Ways to make a dollar are correct"
    (is (= (cc 100 us-coins-alternative-order) 292))))

(run-tests)
