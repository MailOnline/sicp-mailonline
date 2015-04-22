;; Exercise 2.58

(ns sicp-mailonline.exercises.2-58-test
  (:require [sicp-mailonline.exercises.2-58 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-58
  (testing "infix representation"
    (is (= '4
           (deriv '(x + (3 * (x + (y + 2)))) 'x)))
    
    (is (= '((a * (2 * x)) + b)
           (deriv '(((a * (x ** 2)) + (b * x)) + c) 'x)))))
