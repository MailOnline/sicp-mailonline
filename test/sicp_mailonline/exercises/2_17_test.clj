;; Exercise 2.17

(ns sicp-mailonline.exercises.2-17-test
  (:require [sicp-mailonline.exercises.2-17 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-17
  (testing "last-pair"
    (is (= '(34)
           (last-pair (list 23 72 149 34))))

    (is (= '(149)
           (last-pair (list 149))))))
