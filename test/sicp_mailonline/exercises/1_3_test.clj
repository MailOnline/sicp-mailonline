(ns sicp-mailonline.exercises.1-3-test
  (:require [sicp-mailonline.exercises.1-3 :refer :all] 
            [clojure.test :refer :all]))

(defn- test-sum-squares-of-two-largest [f]
  (testing "zero squared is zero"
    (is (= 0
           (f 0 0 0))))
  (testing "one squared is one"
    (is (= 2
           (f 1 1 1))))
  (testing "identifies the two largest values when all values are positive"
    (are [x y z] (= 13 
                    (f x y z))
         1 2 3
         3 1 2
         2 1 3))
  (testing "identifies the two largest values when all values are negative"
    (are [x y z] (= 5 
                    (f x y z))
         -1 -2 -3
         -3 -1 -2
         -2 -3 -1))
  (testing "identifies the two largest values from a mix of positive, zero, and negative values"
    (are [x y z] (= 4 
                    (f x y z))
         2  0 -3
        -3  2  0
         0 -3  2)))

(deftest exercise1-3
  (testing "a solution using only what SICP has illustrated thus far"
    (test-sum-squares-of-two-largest sum-squares-of-two-largest-a))
  (testing "a more idiomatic Clojure solution"
    (test-sum-squares-of-two-largest sum-squares-of-two-largest-b)))
