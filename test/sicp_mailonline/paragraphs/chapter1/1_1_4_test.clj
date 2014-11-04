(ns sicp-mailonline.paragraphs.chapter1.1-1-4-test
  (:require [sicp-mailonline.paragraphs.chapter1.1-1-4 :refer :all]
            [clojure.test :refer :all]))

(deftest test-square
  (testing "Should square a positive number"
    (is (= (square 2) 4)))
  (testing "Should square a negative number"
    (is (= (square -5) 25)))
  (testing "Should square zero"
    (is (= (square 0) 0))))

(deftest test-sum-of-squares
  (testing "Should sum the squares of two positive numbers"
    (is (= (sum-of-squares 3 4) 25)))
  (testing "Should sum the squares of two negative numbers"
    (is (= (sum-of-squares -5 -6) 61)))
  (testing "Should sum the squares of a positive number and a negative number"
    (is (= (sum-of-squares 6 -7) 85))))

(deftest test-f
  (testing "Should calculate correctly with a positive argument"
    (is (= (f 8) 337)))
  (testing "Should calculate correctly with a negative argument"
    (is (= (f -10) 481)))
  (testing "Should calculate correctly with a zero argument"
    (is (= (f 0) 1))))
