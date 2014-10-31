(ns sicp-mailonline.paragraphs.1-1-4-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-4 :refer :all]))

(deftest test-square
  (testing "Square"
    (is (= (square 21) 441))
    (is (= (square (+ 5 2)) 49))
    (is (= (square (square 3)) 81))))

(deftest test-sum-of-squares
  (testing "Sum of squares"
    (is (= (sum-of-squares 3 4) 25))))

(deftest test-f
  (testing "Further building block function"
    (is (= (f 5)) 136)))

