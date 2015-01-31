;; Exercise 2.8

(ns sicp-mailonline.exercises.2-8-test
  (:require [sicp-mailonline.exercises.2-8 :refer :all]
            [sicp-mailonline.exercises.2-7 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-8
  (testing "addition"
    (is (= (make-interval 10.58M 12.42M) 
           (add-interval (make-interval 6.12M 7.48M)
                         (make-interval 4.46M 4.94M)))))

  (testing "subtraction"
    (is (= (make-interval 3.1M 6.3M)
           (sub-interval (make-interval 10.58M 12.42M)
                         (make-interval  6.12M  7.48M))))))
