(ns sicp-mailonline.examples.1-3-4-test
  (:require [sicp-mailonline.examples.1-3-3 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.0001))

(deftest example1-3-4
  (testing "sqrt via newton's method"
    (are [x y] (close-to? y (sqrt x))
          0 0 
          1 1
          2 1.4142
          4 2
          5 2.2361
          9 3)))
