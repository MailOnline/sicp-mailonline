;
; Exercise 2.39
; 

(ns sicp-mailonline.exercises.2-39-test
  (require [sicp-mailonline.exercises.2-39 :refer :all]
           [clojure.test :refer :all]))


(deftest reverse-test
  (testing "reverse 1"
      (is (= (reverse-1 '(1 2 3 4)) '(4 3 2 1))))

  (testing "reverse 2"
      (is (= (reverse-2 '(1 2 3 4)) '(4 3 2 1)))))

(run-tests)
