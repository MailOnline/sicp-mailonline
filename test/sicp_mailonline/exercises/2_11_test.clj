;; Exercise 2.11

(ns sicp-mailonline.exercises.2-11-test
  (:require [sicp-mailonline.exercises.2-11 :refer [mul-interval]
                                            :rename {mul-interval revised-mul-interval}]
            [sicp-mailonline.exercises.2-7 :refer [make-interval mul-interval]
                                           :rename {mul-interval original-mul-interval}]
            [clojure.test :refer :all]))

(def ^:private ^:const a-negative-interval (make-interval -3 -2))
(def ^:private ^:const another-negative-interval (make-interval -4 -1))
(def ^:private ^:const a-mixed-interval (make-interval -2 3))
(def ^:private ^:const another-mixed-interval (make-interval -3 2))
(def ^:private ^:const a-positive-interval (make-interval 3 5))
(def ^:private ^:const another-positive-interval (make-interval 6 8))

(deftest exercise2-11
  (testing "x and y are negative"
    (is (= (make-interval 2 12)
           (original-mul-interval a-negative-interval another-negative-interval)
           (revised-mul-interval a-negative-interval another-negative-interval))))
  
  (testing "x is negative y is mixed"
    (is (= (make-interval -9 6)
           (original-mul-interval a-negative-interval a-mixed-interval)
           (revised-mul-interval a-negative-interval a-mixed-interval))))

  (testing "x is mixed y is negative"
    (is (= (make-interval -9 6)
           (original-mul-interval a-mixed-interval a-negative-interval)
           (revised-mul-interval a-mixed-interval a-negative-interval))))

  (testing "x is negative y is positive"
    (is (= (make-interval -15 -6)
           (original-mul-interval a-negative-interval a-positive-interval)
           (revised-mul-interval a-negative-interval a-positive-interval))))

  (testing "x is positive y is negative"
    (is (= (make-interval -15 -6)
           (original-mul-interval a-positive-interval a-negative-interval)
           (revised-mul-interval a-positive-interval a-negative-interval))))

  (testing "x is mixed y is positive"
    (is (= (make-interval -10 15)
           (original-mul-interval a-mixed-interval a-positive-interval)
           (revised-mul-interval a-mixed-interval a-positive-interval))))

  (testing "x is positive y is mixed"
    (is (= (make-interval -10 15)
           (original-mul-interval a-positive-interval a-mixed-interval)
           (revised-mul-interval a-positive-interval a-mixed-interval))))

  (testing "x and y are positive"
    (is (= (make-interval 18 40)
           (original-mul-interval a-positive-interval another-positive-interval)
           (revised-mul-interval a-positive-interval another-positive-interval))))

  (testing "x and y are mixed"
    (is (= (make-interval -9 6)
           (original-mul-interval a-mixed-interval another-mixed-interval)
           (revised-mul-interval a-mixed-interval another-mixed-interval)))))
