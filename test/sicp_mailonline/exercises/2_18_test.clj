;; Exercise 2.18

(ns sicp-mailonline.exercises.2-18-test
  (:require [sicp-mailonline.exercises.2-18 :refer :all]
            [clojure.test :refer :all]))

(defn- test-reverse [reverse]
  (testing "reverse"
    (is (= '(25 16 9 4 1)
           (reverse (list 1 4 9 16 25))))
    
    (is (= '(1)
           (reverse (list 1))))

    (is (= '()
           (reverse (list))))))

(deftest exercise2-18
  (testing "low level solution"
    (test-reverse reverse-a))

  (testing "more idiomatic Clojure solution"
    (test-reverse reverse-b)))
