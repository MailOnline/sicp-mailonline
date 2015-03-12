;; Exercise 2.32

(ns sicp-mailonline.exercises.2-32-test
  (:require [sicp-mailonline.exercises.2-32 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-32
  (testing "subsets"
    (is (= '(() (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3))
           (subsets '(1 2 3))))))
