;; Exercise 2.20

(ns sicp-mailonline.exercises.2-20-test
  (:require [sicp-mailonline.exercises.2-20 :refer :all]
            [clojure.test :refer :all]))

(defn- test-same-parity [same-parity]
  (testing "same-parity when first argument is odd"
    (is (= '(1 3 5 7)
           (same-parity 1 2 3 4 5 6 7))))

  (testing "same-parity when first argument is even"
    (is (= '(2 4 6)
           (same-parity 2 3 4 5 6 7)))))

(deftest exercise2-20
  (testing "low level solution"
    (test-same-parity same-parity-a))

  (testing "more idiomatic Clojure solution"
    (test-same-parity same-parity-b)))
