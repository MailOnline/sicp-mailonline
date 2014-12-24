;; Exercise 1.38

(ns sicp-mailonline.exercises.1-38-test
  (:require [sicp-mailonline.exercises.1-38 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.000001))

(deftest exercise1-38
  (testing "Euler's expansion"
    (is (close-to? Math/E
                   (approximate-e)))))
