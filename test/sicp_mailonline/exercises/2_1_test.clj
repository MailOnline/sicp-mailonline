;; Exercise 2.1

(ns sicp-mailonline.exercises.2-1-test
  (:require [sicp-mailonline.exercises.2-1 :refer :all]
            [clojure.test :refer :all]))

(defn- test-rational [rational n d]
  (is (= n (first rational)))
  (is (= d (second rational))))

(deftest exercise2-1
  (testing "positive rational numbers"
    (test-rational (make-rat 2 4) 1 2)
    (test-rational (make-rat -2 -4) 1 2))

  (testing "negative rational numbers"
    (test-rational (make-rat -2 4) -1 2)
    (test-rational (make-rat 2 -4) -1 2)))
