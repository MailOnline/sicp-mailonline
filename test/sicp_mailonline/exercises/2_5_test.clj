;; Exercise 2.5

(ns sicp-mailonline.exercises.2-5-test
  (:require [sicp-mailonline.exercises.2-5 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-5
  (testing "pair as a product"
    (let [pair (cons 7 26)]
      (is (= 7 (car pair)))
      (is (= 26 (cdr pair))))))
