;; Exercise 2.10

(ns sicp-mailonline.exercises.2-10-test
  (:require [sicp-mailonline.exercises.2-10 :refer :all]
            [sicp-mailonline.exercises.2-7 :refer [make-interval]]
            [clojure.test :refer :all :exclude [div-interval]]))

(def ^:private ^:const interval-a (make-interval 6.12M 7.48M))
(def ^:private ^:const interval-b (make-interval 4.46M 4.94M))
(def ^:private ^:const interval-spanning-zero (make-interval -1M 2M))
(def ^:private ^:const scale 4)

(deftest exercise2-10
  (testing "divisor interval spans zero"
    (is (thrown? IllegalArgumentException
                 (div-interval interval-a interval-spanning-zero))))

  (testing "divisor interval does not span zero"
    (with-precision scale
      (is (= (make-interval 1.239M 1.677M)
             (div-interval interval-a interval-b))))))
