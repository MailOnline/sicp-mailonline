;; Exercise 1.39

(ns sicp-mailonline.exercises.1-39-test
  (:require [sicp-mailonline.exercises.1-39 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.00001))

(deftest exercise1-39
  (testing "approximating the tangent function"
    (are [x] (close-to? (Math/tan x) (tan-cf x 10))
         (/ Math/PI 3)
         (/ Math/PI 4)
         (/ Math/PI 6))))

;; Note that correct results are not returned for all values of x
;; e.g. tan 45 = 1.61978 but tan-cf returns -2.797784
