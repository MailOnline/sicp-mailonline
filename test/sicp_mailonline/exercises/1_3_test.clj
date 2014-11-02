(ns sicp-mailonline.exercises.1-3-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-3 :refer :all]))

; Define a procedure that takes three numbers as arguments and returns the sum
; of the squares of the two larger numbers.

(deftest test-sum-square-two-larger
  (testing "The sum of the squares of the two larger numbers is returned"
    (is (= (sum-square-two-larger 1 2 3) 13))
    (is (= (sum-square-two-larger 6 2 4) 52))
    (is (= (sum-square-two-larger 3 3 4) 25))
    (is (= (sum-square-two-larger 4 4 3) 32))))

