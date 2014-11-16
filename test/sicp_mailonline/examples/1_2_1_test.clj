;; 1.2.1 Linear Recursion and Iteration

(ns sicp-mailonline.examples.1-2-1-test
  (:require [sicp-mailonline.examples.1-2-1 :refer :all]
            [clojure.test :refer :all]))

(deftest example1-2-1
  (testing "linear recursive factorial"
    (let [factorial rfactorial]
      (is (= 1
             (factorial 1)))
      (is (= 720
             (factorial 6)))))

  (testing "linear iterative factorial"
    (let [factorial ifactorial]
      (is (= 1
             (factorial 1)))
      (is (= 720
             (factorial 6))))))
