(ns sicp-mailonline.exercises.chapter1.1-3-test
  (:require [sicp-mailonline.exercises.chapter1.1-3 :refer :all]
            [clojure.test :refer :all]))

(deftest sum-two-largest-test
  (testing "Should sum two largest"
    (is (= (sum-two-largest 8 2 21) 29))
    (is (= (sum-two-largest -10 -2 -1) -3))
    (is (= (sum-two-largest 1 1 1) 2))))
