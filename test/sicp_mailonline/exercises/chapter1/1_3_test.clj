(ns sicp-mailonline.exercises.chapter1.1-3-test
  (:require [sicp-mailonline.exercises.chapter1.1-3 :refer :all]
            [clojure.test :refer :all]))

(deftest sum-two-largest-test
  (testing "Should sum two largest"
    (is (= (sum-squares-two-largest 8 2 21) 505))
    (is (= (sum-squares-two-largest -10 -2 -1) 5))
    (is (= (sum-squares-two-largest 1 1 1) 2))))
