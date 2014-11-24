;; Exercise 1.18

(ns sicp-mailonline.exercises.1-18-test
  (:require [sicp-mailonline.exercises.1-18 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise1-18
  (testing "multiplication by addition when a is zero"
    (are [b] (= 0 (fast-multiply 0 b))
         -2
          0
          2))

  (testing "multiplication by addition when a is positive"
    (are [a b x] (= x (fast-multiply a b))
         2 -2 -4
         2 -1 -2
         2  0  0
         2  1  2
         2  2  4))

  (testing "multiplication by addition when a is negative"   
    (are [a b x] (= x (fast-multiply a b))
         -2 -2  4
         -2 -1  2
         -2  0  0
         -2  1 -2
         -2  2 -4)))

;;      b  steps (invocations of multipy-iter)
;;      1   2
;;     10   6
;;    100  10
;;  1,000  16
;; 10,000  19
