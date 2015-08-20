;
; Exercise 2.40
; 
(ns sicp-mailonline.exercises.2-40-test
  (require [sicp-mailonline.exercises.2-40 :refer :all]
           [clojure.test :refer :all]))

(def expected '((2 1 3) (3 2 5) (4 1 5) (4 3 7) (5 2 7) (6 1 7) (6 5 11)) )

(deftest prime-sum-pairs-test
  (testing "For pairs summing to 6")
    (is (= expected (prime-sum-pairs 6))))

(run-tests)
