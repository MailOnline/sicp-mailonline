;; Exercise 2.34

(ns sicp-mailonline.exercises.2-34-test
  (:require [sicp-mailonline.exercises.2-34 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-34
  (testing "1 + 3x + 5x^3 + x^5 at x=2"
    (is (= 79
           (horner-eval 2 (list 1 3 0 5 0 1))))))
