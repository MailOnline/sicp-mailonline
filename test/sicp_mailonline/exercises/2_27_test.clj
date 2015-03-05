;; Exercise 2.27

(ns sicp-mailonline.exercises.2-27-test
  (:require [sicp-mailonline.exercises.2-27 :refer :all]
            [clojure.test :refer :all]))

(defn- test-deep-reverse [deep-reverse]
  (is (= '((4 3) (2 1))
         (deep-reverse (list '(1 2) '(3 4)))))
  
  (is (= '(4 3 2 1)
         (deep-reverse (list 1 2 3 4))))
  
  (is (= '((6 5) 4 3 (2 1))
         (deep-reverse (list '(1 2) 3 4 '(5 6))))))

(deftest exercise2-27
  (testing "low-level deep-reverse"
    (test-deep-reverse deep-reverse-a))

  (testing "more idiomatic Clojure deep-reverse"
    (test-deep-reverse deep-reverse-b)))
