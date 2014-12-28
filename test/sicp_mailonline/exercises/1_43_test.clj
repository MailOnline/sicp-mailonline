;; Exercise 1.43

(ns sicp-mailonline.exercises.1-43-test
  (:require [sicp-mailonline.exercises.1-43 :refer :all]
            [clojure.test :refer :all]))

(defn- square [n]
  (* n n))

(deftest exercise1-43
  (testing "repeated addition"
    (is (= 10
           ((repeated inc 10) 0))))
  
  (testing "repeated square"
    (is (= 625
           ((repeated square 2) 5))))

  (testing "Clojure built-in 'iterate' returns a seq of x,f(x),f(f(x)),..."
    (is (= 625
           (nth (iterate square 5) 2)))))
