;; Exercise 2.53
;; What would the interpreter print in respone to evaluating each of the
;; following expressions?
;;
;; (list 'a 'b 'c)
;; (list (list 'george))
;; (cdr '((x1 x2) (y1 y2)))
;; (cadr '((x1 x2) (y1 y2)))
;; (pair? (car '(a short list)))
;; (memq 'red '((red shoes) (blue socks)))
;; (memq 'red '(red shoes blue socks))

(ns sicp-mailonline.exercises.2-53-test
  (:require [sicp-mailonline.examples.2-3-1 :refer [memq]]
            [clojure.test :refer :all]))

(deftest exercise2-53
  (testing "(list 'a 'b 'c)"
    (is (= '(a b c)
           (list 'a 'b 'c))))

  (testing "(list (list 'george))"
    (is (= '((george))
           (list (list 'george)))))

  (testing "(cdr '((x1 x2) (y1 y2)))"
    (is (= '((y1 y2))
           (rest '((x1 x2) (y1 y2))))))

  (testing "(cadr '((x1 x2) (y1 y2)))"
    (is (= '(y1 y2)
           (first (rest '((x1 x2) (y1 y2)))))))

  (testing "(pair? (car '(a short list)))"
    (is (not (coll? (first '(a short list))))))

  (testing "(memq 'red '((red shoes) (blue socks)))"
    (is (not (memq 'red '((red shoes) (blue socks))))))

  (testing "(memq 'red '(red shoes blue socks))"
    (is (= '(red shoes blue socks)
           (memq 'red '(red shoes blue socks))))))
