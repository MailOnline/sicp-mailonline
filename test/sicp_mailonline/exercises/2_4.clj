; 
; Exercise 2.4
;
(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest mcar-test
    (testing "car"
      (is (= (mcar (mcons 3 7)) 3))))

(deftest mcar-test
    (testing "car"
      (is (= (mcdr (mcons 3 7)) 7))))

(run-all-tests)
