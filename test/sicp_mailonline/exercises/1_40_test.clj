;; Exercise 1.40

(ns sicp-mailonline.exercises.1-40-test
  (:require [sicp-mailonline.exercises.1-40 :refer [cubic]]
            [sicp-mailonline.examples.1-3-4 :refer [newtons-method]]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.001))

(deftest exercise1-40
  (testing "finding x where y=0 for the cubic x^3 + ax^2 + bx + c"
    (is (close-to? -3.981
                   (newtons-method (cubic 3 -2.4 6) 1)))))
