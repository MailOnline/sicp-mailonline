;; Exercise 2.12

(ns sicp-mailonline.exercises.2-12-test
  (:require [sicp-mailonline.exercises.2-12 :refer :all]
            [sicp-mailonline.exercises.2-7 :refer [lower-bound upper-bound]]
            [clojure.test :refer :all]))

(deftest exercise2-12
  (testing "6.8 ohms with 10% tolerance"
    (with-precision 3
      (let [interval (make-center-percent 6.8M 10)]
        (is (= 6.12M
               (lower-bound interval)))
        (is (= 7.48M
               (upper-bound interval)))
        (is (= 6.80M
               (center interval)))
        (is (= 0.68M
               (width interval)))
        (is (= 10M
               (percent interval)))))))
