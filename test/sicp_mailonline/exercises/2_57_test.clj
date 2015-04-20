;; Exercise 2.57

(ns sicp-mailonline.exercises.2-57-test
  (:require [sicp-mailonline.exercises.2-57 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-57
  (testing "more than two sum terms"
    (is (= '(+ (* a (* 2 x)) b)
           (deriv '(+ (* a (** x 2)) (* b x) c) 'x))))
  
  (testing "more than two product terms"
    (is (= '(+ (* x y) (* y (+ x 3)))
           (deriv '(* x y (+ x 3)) 'x)))))
