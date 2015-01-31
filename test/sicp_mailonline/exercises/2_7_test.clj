;; Exercise 2.7

(ns sicp-mailonline.exercises.2-7-test
  (:require [sicp-mailonline.exercises.2-7 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-7
  (testing "selectors"
    (let [interval (make-interval 6.12 7.48)]
      (is (= 6.12
             (lower-bound interval)))

      (is (= 7.48
             (upper-bound interval))))))
