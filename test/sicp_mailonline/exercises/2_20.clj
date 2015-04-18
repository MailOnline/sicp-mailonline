; 
; Exercise 2.20
;

(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest same-parity-test
  (testing "Same parity of empty list is the empty list"
    (is (empty? (same-parity '()))))

  (testing "Same parity of (1 2 3 4)"
    (is 
      (=
        (same-parity '(1 2 3 4))
        '(1 3)))))

(run-tests)
