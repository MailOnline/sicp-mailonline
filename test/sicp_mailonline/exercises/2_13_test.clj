;; Exercise 2.13
;; Show that under the assumption of small percentage tolerances there is a
;; simple formula for the approximate percentage tolerance of the product of
;; two intervals in terms of the tolerances of the factors.  You may simplify
;; the problem by assuming that all numbers are positive.

(ns sicp-mailonline.exercises.2-13-test
  (:require [sicp-mailonline.exercises.2-12 :refer :all]
            [sicp-mailonline.exercises.2-7 :refer :all]
            [clojure.test :refer :all]))

(^:private ^:const def interval-with-tolerance-10 (make-center-percent 6.8M 10))
(^:private ^:const def interval-with-tolerance-5 (make-center-percent 4.7M 5))
(^:private ^:const def scale 3)

(deftest exercise2-13
  (testing "tolerance of the product of two intervals can be approximated by the sum of the tolerances"
    (with-precision scale
      (let [product (mul-interval interval-with-tolerance-10 interval-with-tolerance-5)]
        (is (= 15M
               (percent product)))
        
        (is (= (+ (percent interval-with-tolerance-10)
                  (percent interval-with-tolerance-5))
               (percent product)))))))
