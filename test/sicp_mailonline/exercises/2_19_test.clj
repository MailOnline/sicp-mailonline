;; Exercise 2.19

(ns sicp-mailonline.exercises.2-19-test
  (:require [sicp-mailonline.exercises.2-19 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const us-coins (list 50 25 10 5 1))
(def ^:private ^:const uk-coins (list 100 50 20 10 5 2 1 0.5))
(def ^:private ^:const no-coins '())

(deftest exercise2-19
  (testing "negative amount"
    (is (zero? (cc -1 us-coins))))

  (testing "no coins"
    (is (zero? (cc 1 no-coins))))

  (testing "zero amount"
    (is (= 1
           (cc 0 us-coins))))
  
  (testing "us coins"
    (is (= 1
           (cc 1 us-coins)))
    
    (is (= 292
           (cc 100 us-coins))))

  (testing "uk coins"
    (is (= 2
           (cc 1 uk-coins)))
    
    (is (= 104561
           (cc 100 uk-coins))))

  (testing "the order of coin values does not affect the result"
    (is (= 292
           (cc 100 '(1 5 10 25 50))
           (cc 100 '(5 50 1 10 25))
           (cc 100 '(50 25 10 5 1))
           (cc 100 '(5 1 25 10 50))))))
