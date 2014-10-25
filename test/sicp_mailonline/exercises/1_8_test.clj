(ns sicp-mailonline.exercises.1-8-test
  (:require [sicp-mailonline.exercises.1-8 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [x y]
  (< (Math/abs (- x y)) 0.001))

(deftest exercise1-8
  (testing "cube-root of zero"
    (is (= 0 (cube-root 0))))

  (testing "cube-root of positive values"
    (are [y x] (close-to? y (cube-root x))
      1  1
      2  8
      3 27))

  (testing "cube-root of negative values"
    (are [y x] (close-to? y (cube-root x))
      -1  -1
      -2  -8
      -3 -27))
  
  (testing "cube-root of small values"
    (are [x] (close-to? (Math/cbrt x) (cube-root x))
      -0.003
      -0.001       
       0.001
       0.003))

  (testing "cube-root of large value"
    (let [large-value 9223372036854775807]
      (is (close-to? (Math/cbrt large-value)
                     (cube-root large-value))))))
