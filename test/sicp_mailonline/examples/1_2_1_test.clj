;; 1.2.1 Linear Recursion and Iteration

(ns sicp-mailonline.examples.1-2-1-test
  (:require [sicp-mailonline.examples.1-2-1 :refer :all]
            [clojure.test :refer :all]))

(defn- test-factorial [f]
  (are [n x] (= x (f n))
       1   1
       6 720))

(deftest example1-2-1
  (testing "linear recursive factorial"
    (let [factorial rfactorial]
      (test-factorial factorial)))

  (testing "linear iterative factorial"
    (let [factorial ifactorial]
      (test-factorial factorial))))
