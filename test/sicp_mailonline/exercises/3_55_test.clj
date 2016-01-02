;; Exercise 3.55

(ns sicp-mailonline.exercises.3-55-test
  (:require [sicp-mailonline.examples.3-5-1 :refer [stream-ref]]
            [sicp-mailonline.examples.3-5-2 :refer [integers]]
            [sicp-mailonline.exercises.3-55 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise3-55
  (testing "partial-sums"
    (are [n s] (= s (stream-ref (partial-sums integers) n))
      0  1
      1  3
      2  6
      3 10
      4 15)))
