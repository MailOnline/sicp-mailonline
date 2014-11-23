;; Exercise 1.17

(ns sicp-mailonline.exercises.1-17-test
  (:require [sicp-mailonline.exercises.1-17 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise1-17
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

;;      b  steps (invocations of fast-multiply)
;;      1   1
;;     10   5
;;    100   9
;;  1,000  15
;; 10,000  18
