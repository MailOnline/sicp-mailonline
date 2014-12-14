(ns sicp-mailonline.examples.1-3-1-test
  (:require [sicp-mailonline.examples.1-3-1 :refer :all]
            [clojure.test :refer :all]))

(deftest example1-3-1
  (testing "sum cubes"
    (is (= 3025
           (sum-cubes 1 10))))

  (testing "sum integers"
    (is (= 55
           (sum-integers 1 10))))

  (testing "an approximation to pi"
    (is (= 3.139592655589783
           (* 8 (pi-sum 1 1000)))))

  (testing "integral of cube between 0 and 1"
    (are [x y] (= y (integral cube 0 1 x))
         0.01  0.24998750000000042
         0.001 0.249999875000001)))
