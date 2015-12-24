(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest square-test
  (testing "Test square"
    (is (= 4 (square 2)))))

(deftest sum-of-square-test
  (testing "Test sum of square"
    (is (= (sum-of-squares 3 4)  25))))

(run-all-tests)
