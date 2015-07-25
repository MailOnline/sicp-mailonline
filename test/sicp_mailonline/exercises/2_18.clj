; 
; Exercise 2.18
;
(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-18 :refer :all]))


(deftest test-new-reverse
  (testing "testing empty list"
    (is (= (new-reverse ()) ())))
  
  (testing "testing one element"
    (is (= (new-reverse (list 1)) '(1))))

  (testing "testing two elements"
    (is (= (new-reverse (list 1 2)) '(2 1))))

  (testing "testing three elements"
    (is (= (new-reverse (list 1 2 3)) '(3 2 1)))))

(run-tests)

