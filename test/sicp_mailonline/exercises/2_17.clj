; 
; Exercise 2.17
;
(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest last-pair-test
  (testing "empty list"
    (is (= (last-pair ()) ())))

  (testing "one element"
    (is (= (last-pair (list 1)) 1)))

  (testing "two elements"
    (is (= (last-pair (list 1 2)) 2)))
  
  (testing "three elements"
    (is (= (last-pair (list 1 2 3)) 3))))
  
(run-tests)

