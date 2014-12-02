(ns sicp-mailonline.exercises.1-10-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-10 :refer :all]))

(deftest test-one
  (testing "A 1 10"
    (is (= 1024 (A 1 10)))))
; A 1 10
; = 2 ^ 10

(deftest test-one
  (testing "A 1 10"
    (is (= 1024 (A 1 10)))))

(deftest test-two
  (testing "A 2 4"
    (is (= 65536 (A 2 4)))))
; = 2 ^ 16

(deftest test-three
  (testing "A 3 3"
    (is (= 65536 (A 3 3)))))
; = 2 ^ 16
