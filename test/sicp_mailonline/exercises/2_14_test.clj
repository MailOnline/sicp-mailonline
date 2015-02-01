;; Exercise 2.14

(ns sicp-mailonline.exercises.2-14-test
  (:require [sicp-mailonline.exercises.2-14 :refer :all]
            [sicp-mailonline.exercises.2-12 :refer :all]
            [sicp-mailonline.exercises.2-7 :refer :all]
            [clojure.test :refer :all]))

(^:private ^:const def interval-a (make-center-percent 10 1))
(^:private ^:const def interval-b (make-center-percent 20 1))
(^:private ^:const def scale 3)

(deftest exercise2-14
  (testing "the two approaches give different results"
    (with-precision scale
      (let [x (par1 interval-a interval-b)
            y (par2 interval-a interval-b)]
        (is (= (center x)
               (center y)))

        (is (= 3.01M
               (percent x)))
        (is (= 0.977M
               (percent y)))
        (is (not= (percent x) (percent y)))

        (is (= 6.47M
               (lower-bound x)))
        (is (= 6.58M
               (lower-bound y)))
        (is (not= (lower-bound x) (lower-bound y)))
        
        (is (= 6.87M
               (upper-bound x)))
        (is (= 6.71M
               (upper-bound y)))
        (is (not= (upper-bound x) (upper-bound y))))))

  (testing "A/A"
    (with-precision scale
      (let [ratio (div-interval interval-a interval-a)]
        (is (= 1M
               (center ratio)))

        (is (= 2M
               (percent ratio))))))

  (testing "A/B"
    (with-precision scale
      (let [ratio (div-interval interval-a interval-b)]
        (is (= 0.5M
               (center ratio)))

        (is (= 2M
               (percent ratio)))))))
