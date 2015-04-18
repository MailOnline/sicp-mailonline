; 
; Exercise 2.21
;

(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest square-list-test
  (testing "Square list of an empty list is the empty list"
    (is (empty? (square-list nil))))

  (testing "Square list of a non-empty list"
    (is
      (=
        (square-list '(1 2 3 4)) 
        '(1 4 9 16)))))


(deftest square-list-2-test
  (testing "Square list of an empty list is the empty list"
    (is (empty? (square-list-2 nil))))

  (testing "Square list of a non-empty list"
    (is
      (=
        (square-list-2 '(1 2 3 4)) 
        '(1 4 9 16)))))


(run-tests)

