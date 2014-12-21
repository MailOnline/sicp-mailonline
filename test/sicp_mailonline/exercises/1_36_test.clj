;; Exercise 1.36
;; Modify fixed-point so that it prints the sequence of approximations it
;; generates, using the newline and display primitives shown in exercise 1.22.
;; Then find a solution to x^x = 1000 by finding a fixed point of
;; x |-> log(1000)/log(x).  (Use Scheme's primitive log procedure, which
;; computes natural logarithms.)  Compare the number of steps this takes with
;; and without average damping.  (Note that you cannot start fixed-point with
;; a guess of 1, as this would cause division by log(1)=0.)

(ns sicp-mailonline.exercises.1-36-test
  (:require [sicp-mailonline.exercises.1-36 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.00001))

(deftest exercise1-36
  (testing "without average damping"
    (is (close-to? 4.55553
                   (x-to-x))))

;; 34 steps taken - output as follows:
;; guess was:  9.965784284662087
;; guess was:  3.004472209841214
;; guess was:  6.279195757507157
;; guess was:  3.759850702401539
;; guess was:  5.215843784925895
;; guess was:  4.182207192401397
;; guess was:  4.8277650983445906
;; guess was:  4.387593384662677
;; guess was:  4.671250085763899
;; guess was:  4.481403616895052
;; guess was:  4.6053657460929
;; guess was:  4.5230849678718865
;; guess was:  4.577114682047341
;; guess was:  4.541382480151454
;; guess was:  4.564903245230833
;; guess was:  4.549372679303342
;; guess was:  4.559606491913287
;; guess was:  4.552853875788271
;; guess was:  4.557305529748263
;; guess was:  4.554369064436181
;; guess was:  4.556305311532999
;; guess was:  4.555028263573554
;; guess was:  4.555870396702851
;; guess was:  4.555315001192079
;; guess was:  4.5556812635433275
;; guess was:  4.555439715736846
;; guess was:  4.555599009998291
;; guess was:  4.555493957531389
;; guess was:  4.555563237292884
;; guess was:  4.555517548417651
;; guess was:  4.555547679306398
;; guess was:  4.555527808516254
;; guess was:  4.555540912917957
;; guess was:  4.555532270803653
  
  (testing "with average damping"
    (is (close-to? 4.55553
                   (x-to-x-damped)))))

;; 9 steps taken - output as follows:
;; guess was:  5.9828921423310435
;; guess was:  4.922168721308343
;; guess was:  4.628224318195455
;; guess was:  4.568346513136242
;; guess was:  4.5577305909237005
;; guess was:  4.555909809045131
;; guess was:  4.555599411610624
;; guess was:  4.5555465521473675
;; guess was:  4.555537551999825
