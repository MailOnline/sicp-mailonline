;; Exercise 2.26
;; Suppose we define x and y to be two lists:
;;   (define x (list 1 2 3))
;;   (define y (list 4 5 6))
;; What result is printed by the interpreter in response to evaluating each of
;; the following expressions:
;;
;;   (append x y)
;;   (cons x y)
;;   (list x y)

(ns sicp-mailonline.exercises.2-26-test
  (:require [sicp-mailonline.examples.2-2-1 :refer [append]]
            [clojure.test :refer :all]))

(def ^:private ^:const x (list 1 2 3))
(def ^:private ^:const y (list 4 5 6))

(deftest exercise2-26
  (testing "(append x y)"
    (is (= '(1 2 3 4 5 6)
           (append x y))))
  
  (testing "(cons x y)"
    (is (= '((1 2 3) 4 5 6)
           (cons x y))))
  
  (testing "(list x y)"
    (is (= '((1 2 3) (4 5 6))
           (list x y)))))
