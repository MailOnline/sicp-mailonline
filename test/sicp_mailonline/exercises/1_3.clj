(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest square-test
    (testing "Square"
        (is (= 16 (square 4)))))

(deftest sum-of-squares-test
    (testing "Sum of squares"
        (is (= 41 (sum-of-squares 4 5)))))

(deftest sum-of-squares-largest-test
  (testing "Sum of squares largest"
    (is (= 41 (sum-of-squares-largest 3 4 5)))
    (is (= 41 (sum-of-squares-largest 4 5 3)))
    (is (= 41 (sum-of-squares-largest 4 5 4)))))

(run-all-tests)
