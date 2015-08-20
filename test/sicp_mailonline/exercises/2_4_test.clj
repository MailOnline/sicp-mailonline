; 
; Exercise 2.4
;
(ns sicp-mailonline.exercises.2-4.test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-4 :refer :all]))

(deftest mcar-test
    (testing "car"
      (is (= (mcar (mcons 3 7)) 3))))

(deftest mcar-test
    (testing "car"
      (is (= (mcdr (mcons 3 7)) 7))))

(run-tests)
