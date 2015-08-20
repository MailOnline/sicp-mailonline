;
; Exercise 2.22
;

(ns sicp-mailonline.exercises.2-22-test
  (require [clojure.test :refer :all]
           [sicp-mailonline.exercises.2-22 :refer :all]))

(deftest square-list-test
  (testing "standard squence"
    (is (= (square-list '(1 2 3)) '(1 4 9)))))

(run-tests)
