;; Exercise 3.8

(ns sicp-mailonline.exercises.3-8-test
  (:require [sicp-mailonline.exercises.3-8 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise3-8
  (testing "Clojure evaluates left to right"
    (let [f (make-f)]
      (is (= 0
             (+ (f 0) (f 1))))))
  
  (testing "the pitfalls of assignment"
    (let [f (make-f)]
      (is (= 1
             (+ (f 1) (f 0)))))))
