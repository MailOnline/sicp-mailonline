;; Exercise 1.7
;; The good-enough? test used in computing square roots will not be
;; very effective for finding the square root of very small numbers.
;; Also, in real computers, arithmetic operations are almost always
;; performed with limited precision.  This makes our test inadequate
;; for very large numbers.  
;; Explain these statements, with examples showing how the test fails
;; for small and large numbers.
;;
;; An alternative strategy for implementing good-enough? is to watch
;; how guess changes from one iteration to the next and to stop when
;; the change is a very small fraction of the guess.  
;; Design a square root procedure that uses this kind of test.  
;; Does this work better for small and large numbers?

(ns sicp-mailonline.exercises.1-7-test
  (:require [sicp-mailonline.exercises.1-7 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [x y]
  (< (Math/abs (- x y)) 0.001))

(deftest exercise1-7
  (testing "fixed tolerance approach of example"
    (let [sqrt fixed-tolerance-sqrt]
      (testing "square root of a very small number"
        (is (not (close-to? (Math/sqrt 0.001)            ;; 0.0316...
                            (sqrt 0.001)))))             ;; 0.0412...
      (testing "square root of a very large number"
        (is (thrown? StackOverflowError (sqrt 9223372036854775807))))))

  (testing "stabilising proportional change approach of exercise"
    (let [sqrt stabilising-delta-sqrt]
      (testing "square root of a very small number"
        (is (close-to? (Math/sqrt 0.001)                 ;; 0.0316...
                       (sqrt 0.001))))
      (testing "square root of a very large number"
        (is (close-to? (Math/sqrt 9223372036854775807)   ;; 3.037E9...
                       (sqrt 9223372036854775807)))))))

;; ==================================================================
;; For very small numbers, a fixed tolerance of 0.001 can represent a
;; significant error in proportional terms:
;;   (sqrt 0.001) => 0.0412
;;   (square 0.0412) => 0.001697
;;   error = (- 0.001697 0.001) = 0.000697
;; This error looks small in absolute terms, but results in an answer
;; that is 30% higher than expected.
;; 
;; For very large numbers, the imprecision of a floating point 
;; representation can result in the fixed tolerance solution
;; failing to converge on a good-enough guess, and hence an
;; infinite loop.  For example, it may not be possible to represent
;; the result of improve precisely enough for it to ever satisfy
;; close-enough?  Without tail-call optimisation, this results
;; in a stack overflow error.
;;
;; Yes, the stabilising proportional change approach does work better
;; for small and large numbers.
