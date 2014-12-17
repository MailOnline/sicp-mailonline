;; Exercise 1.33

(ns sicp-mailonline.exercises.1-33-test
  (:require [sicp-mailonline.exercises.1-33 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise1-33
  (testing "sum of the squares of the prime numbers in the interval"
    (are [x a b] (= x (sum-squares-primes a b))
         87 1 10     ; primes=2,3,5,7  
          0 1  1     ; primes=none
          4 1  2))   ; primes=2

  (testing "product of positive integers less than and relatively prime to n"
    (are [x n] (= x (product-relatively-primes n))
         189 10      ; relatively-prime=3,7,9
           2  3      ; relatively-prime=2
           1  1)))   ; the null-value is returned, which is technically incorrect
