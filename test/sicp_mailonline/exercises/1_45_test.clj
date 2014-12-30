;; Exercise 1.45

(ns sicp-mailonline.exercises.1-45-test
  (:require [sicp-mailonline.exercises.1-45 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.0001))

(deftest exercise1-45
  (testing "nth-root"
    (are [y n] (close-to? y (nth-root 100 n))
         100.0000   1
          10.0000   2
           4.6416   3
           3.1623   4
           1.7783   8
           1.3335  16
           1.1548  32)))
