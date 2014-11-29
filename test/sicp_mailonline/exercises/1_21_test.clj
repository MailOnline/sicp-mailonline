;; Exercise 1.21
;; Use the smallest-divisor procedure to find the smallest divisor of each of
;; the following numbers: 199, 1999, 19999.

(ns sicp-mailonline.exercises.1-21-test
  (:require [sicp-mailonline.examples.1-2-6 :refer [smallest-divisor]]
            [clojure.test :refer :all]))

(deftest exercise1-21
  (testing "smallest-divisor"
    (are [n x] (= x (smallest-divisor n))
        199   199
       1999  1999
      19999     7)))
