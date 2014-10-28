(ns sicp-mailonline.exercises.1-3-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-3 :refer :all]))

(deftest sum-of-squares-test
  (testing "first version simple cond"
    (are [x y] (= x y)
         (sum-of-squares 0 0 0) 0
         (sum-of-squares 1 1 1) 2
         (sum-of-squares 2 2 2) 8
         (sum-of-squares 0 1 2) 5
         (sum-of-squares 3 2 1) 13
         (sum-of-squares 1 2 3) 13)))
