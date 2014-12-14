;; Exercise 1.29

(ns sicp-mailonline.exercises.1-29-test
  (:require [sicp-mailonline.exercises.1-29 :refer :all]
            [sicp-mailonline.examples.1-3-1 :refer [cube]]
            [clojure.test :refer :all]))

(deftest exercise1-29
  (testing "integral of cube between 0 and 1"
    (are [n y] (= y (integral cube 0 1 n))
         100  1/4   
         1000 1/4)))

;; the results computed using Simpson's rule are more accurate, achieving the
;; target result of 1/4.
