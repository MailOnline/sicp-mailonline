;; Exercise 2.56

(ns sicp-mailonline.exercises.2-56-test
  (:require [sicp-mailonline.exercises.2-56 :refer [deriv]]
            [clojure.test :refer :all]))

(deftest exercse2-56
  (testing "exponentiation"
    ;; x -> 1
    (is (= 1
           (deriv '(** x 1) 'x)))

    ;; x^2 -> 2x
    (is (= '(* 2 x)
           (deriv '(** x 2) 'x)))

    ;; ax^2 + bx + c -> 2ax + b
    (is (= '(+ (* a (* 2 x)) b)
           (deriv '(+ (+ (* a (** x 2)) (* b x)) c) 'x)))))
