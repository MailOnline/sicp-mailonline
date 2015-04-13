;; Exercise 2.54

(ns sicp-mailonline.exercises.2-54-test
  (:require [sicp-mailonline.exercises.2-54 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-54
  (testing "lists"
    (is (equal? '()
                '()))
    
    (is (equal? '(this is a list)
                '(this is a list)))

    (is (not (equal? '()
                     '(this is a list))))

    (is (not (equal? '(this is a list)
                     '(this (is a) list)))))

  (testing "symbols"
    (is (equal? 'a
                'a))

    (is (not (equal? 'a
                     'b))))

  (testing "values"
    (is (equal? 42
                42))

    (is (not (equal? 42
                     43)))))
