;; Exercise 2.35

(ns sicp-mailonline.exercises.2-35-test
  (:require [sicp-mailonline.exercises.2-35 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const x (cons (list 1 2) (list 3 4)))

(defn- test-count-leaves [count-leaves]
  (testing "count-leaves"
    (is (= 4
           (count-leaves x)))

    (is (= 8
           (count-leaves (list x x))))

    (is (= 0
           (count-leaves '())))

    (is (= 1
           (count-leaves (list 7))))))

(deftest exercise2-35
  (testing "solution using recursive lambda"
    (test-count-leaves count-leaves-a))
  
  (testing "solution using flat leaf sequence"
    (test-count-leaves count-leaves-b)))
