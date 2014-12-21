(ns sicp-mailonline.examples.1-3-3-test
  (:require [sicp-mailonline.examples.1-3-3 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [x y]
  (< (Math/abs (- x y)) 0.000000001))

(deftest examples1-3-3
  (testing "fixed-point of the cosine function"
    (is (close-to? 0.7390822985224023
                   (fixed-point (fn [y] (Math/cos y)) 1.0))))

  (testing "solution to y = sin y + cos y"
    (is (close-to? 1.2587315962971173
                   (fixed-point (fn [y] (+ (Math/sin y) (Math/cos y)))
                                1.0))))

  (testing "sqrt via average damping"
    (are [x y] (close-to? y (sqrt x))
         1 1.0
         2 1.4142135623
         3 1.7320508075
         4 2)))
