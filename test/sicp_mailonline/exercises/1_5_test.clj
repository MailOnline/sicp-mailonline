;; Exercise 1.5
;; Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with is using applicative-order evaluation or normal-order evaluation.
;; He defines the following two procedures:
;;
;; (define (p)
;;   (p))
;;
;; (define (test x y)
;;   (if (= x 0)
;;     0
;;     y))
;;
;; Then he evaluates the expression
;;
;; (test 0 (p))
;;
;; What behaviour will Ben observe with an interpreter that uses applicative-order evaluation?
;; What behaviour will he observe with an interpreter that uses normal-order evaluation?
;; Explain your answer.
;; (Assume that the evaluation rule for the special form if is the same whether the interpreter is using normal or applicative order:
;; The predicate expression is evaluated first, and the result determines whether to evaluate the consequent or the alternative expression.)

;; ============================
;; applicative-order evaluation
;; ============================
(ns sicp-mailonline.exercises.1-5-test
  (:require [clojure.test :refer :all]))

(defn- p []
  (p))

(defn- test [x y]
  (if (= x 0)
    0
    y))

(deftest exercise1-5
  (testing "applicative-order evaluation results in a StackOverflowError"
    (is (thrown? StackOverflowError (test 0 (p))))))

;; "evaluate the arguments and then apply".
;; The interpreter first evaluates the operator and the operands, and then applies the resulting procedure to the resulting arguments.
;; As an attempt is made to evaluate the argument (p), the interpreter enters an infinte recursion.
;; As Clojure does not automatically perform tail-call optimization (in contrast to Scheme), this will result in a StackOverflowError.

;; Note that the use of recur can emulate Scheme's tail-call optimization here, if p is defined as follows:
;; (defn- p []
;;   (recur))

;; With this definition there will be no StackOverflowError - the procedure will simply recur infinitely. 

;; =======================
;; normal-order evaluation
;; =======================
;; "fully expand and then reduce".
;; The interpreter does not evaluate the operands until their values are needed.
;; As there is no need to actually evaluate (p) when x is zero, the interpreter will return 0 after evaluating the predicate condition.
