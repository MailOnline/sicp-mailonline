; 
; Exercise 2.20
;

(ns sicp-mailonline.exercises.2-20-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-20 :refer :all]))

(deftest same-parity-test
  (testing "Same parity of list with one element is true"
    (is (= (same-parity 1) '(1))))

  (testing "Same parity of 1 2 3 4"
    (is (= (same-parity 1 2 3 4)
        '(1 3)))))

(run-tests)
