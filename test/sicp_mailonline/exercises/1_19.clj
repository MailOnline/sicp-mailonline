; 
; Exercise 1.19
;
(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest fibn-test
    (testing "fibn"
      (is (=  '(0 1 1 2 3 5 8 13 21)
              (map fibn [0 1 2 3 4 5 6 7 8])))))

(deftest fibn-mat-test
    (testing "fibn-mat"
      (is (=  '(0 1 1 2 3 5 8 13 21)
              (map fibn-mat [0 1 2 3 4 5 6 7 8])))))

(run-all-tests)
