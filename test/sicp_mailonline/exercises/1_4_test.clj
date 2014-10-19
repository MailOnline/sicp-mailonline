;; Exercise 1.4
;; Observe that our model of evaluation allows for combinations whose operators are compound expressions.
;; Use this observation to describe the behaviour of the following procedure:
;;
;; (define (a-plus-abs-b a b)
;;   ((if (> b 0) + -) a b))

(ns sicp-mailonline.exercises.1-4-test
  (:require [clojure.test :refer :all]))

(defn- a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(deftest exercise1-4
  (testing "b is positive"
    (is (= 3
           (a-plus-abs-b 1 2))))
  (testing "b is negative"
    (is (= 3
           (a-plus-abs-b 1 -2))))
  (testing "b is zero"
    (is (= 1
           (a-plus-abs-b 1 0)))))

;; The if expression returns a function, either '+' if b is positive, otherwise '-'.
;; The resulting expression evaluates the operands 'a' and 'b' with this function.
;; The result is the sum of a and |b|.

;; when (> b 0) => (+ a b) => (+ a |b|)
;; when (< b 0) => (- a b) => (+ a |b|)
;; when (= b 0) => (- a b) => a
