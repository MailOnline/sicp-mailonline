; 
; Exercise 2.6
;
(ns sicp-mailonline.exercises.2-6.test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-6 :refer :all]))

(defn square [a]
  (* a a))

(deftest zero-test
    (testing "zero"
      (is (= ((zero square) 2) 2))))

(deftest add-1-test
  (testing "add-1"
    (is (= (((add-1 zero) square) 2)              4))
    (is (= (((add-1 (add-1 zero)) square) 2)      16))
    (is (= (((add-1 one) square) 2)               16))))

(deftest add-test
  (testing "1 + 1 = 2"
    (is (= (((add one one) square) 2) ((two square) 2))))
  (testing "1 + 2 = 3"
    (is (= (((add one two) square) 2) ((three square) 2)))))

(run-tests)

