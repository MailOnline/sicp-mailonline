;; Exercise 2.39

(ns sicp-mailonline.exercises.2-39-test
  (:require [sicp-mailonline.exercises.2-39 :refer :all]
            [clojure.test :refer :all]))

(defn- test-reverse [reverse]
  (is (= '(4 3 2 1)
         (reverse '(1 2 3 4)))))

(deftest exercise2-39
  (testing "reverse using fold-right"
    (test-reverse reverse-right))
  
  (testing "reverse using fold-left"
    (test-reverse reverse-left)))
