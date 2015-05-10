;; Exercise 2.73

(ns sicp-mailonline.exercises.2-73-test
  (:require [sicp-mailonline.exercises.2-73 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-73
  (install-deriv!)
  
  (testing "symbolic differentiation of addition expression"
    (is (= 1
           (deriv '(+ x 3) 'x))))
  
  (testing "symbolic differentiation of multiplication expression"
    (is (= 'y
           (deriv '(* x y) 'x))))

  (testing "symbolic differentiation of exponentiation expression"
    (is (= 1
           (deriv '(** x 1) 'x)))

    (is (= '(* 2 x)
           (deriv '(** x 2) 'x))))
  
  (testing "symbolic differentiation of combined expressions"
    (is (= '(+ (* a (* 2 x)) b)
           (deriv '(+ (+ (* a (** x 2)) (* b x)) c) 'x)))))
