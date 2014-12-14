;; Exercise 1.32

(ns sicp-mailonline.exercises.1-32-test
  (:require [sicp-mailonline.exercises.1-32 :refer :all]
            [clojure.test :refer :all]))

(defn- cube [x]
  (* x x x))

(defn- approximate-pi [accumulate]
  (letfn [(term [denom]
            (* (/ (dec denom) denom)
               (/ (inc denom) denom)))
          (next [denom]
            (if (odd? denom)
              (+ 2 denom)
              (inc denom)))]
    (* 4
       ((make-product accumulate term next) 3 7))))

(defn- test-sum [accumulate]
  (testing "can represent the sum special case"
    (testing "and sum integers"
      (is (= 55
             ((make-sum accumulate identity inc) 1 10))))
    (testing "and sum cubes"
      (is (= 3025
             ((make-sum accumulate cube inc) 1 10))))))

(defn- test-product [accumulate]
  (testing "can represent the product special case"
    (testing "and calculate the factorial"
      (is (= 3628800
             ((make-product accumulate identity inc) 1 10))))
    (testing "and calculate an approximation of pi"
      (is (= 36864/11025
             (approximate-pi accumulate))))))

(deftest exercise1-32
  (testing "a recursive general-purpose accumulate function"
    (test-sum raccumulate)
    (test-product raccumulate))

  (testing "an iterative general-purpose accumulate function"
    (test-sum iaccumulate)
    (test-product iaccumulate)))
