;; Exercise 2.6

(ns sicp-mailonline.exercises.2-6-test
  (:require [sicp-mailonline.exercises.2-6 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-6
  (testing "zero"
    (is (= 0
           ((zero inc) 0))))

  (testing "one"
    (is (= 1
           ((one inc) 0))))

  (testing "two"
    (is (= 2
           ((two inc) 0))))

  (testing "add-1"
    (is (= 1
           (((add-1 zero) inc) 0)))

    (is (= 2
           (((add-1 one) inc) 0)))

    (is (= 3
           (((add-1 two) inc) 0))))

  (testing "add"
    (is (= 0
           (((add zero zero) inc) 0)))

    (is (= 1
           (((add zero one) inc) 0)))

    (is (= 2
           (((add one one) inc) 0)))

    (is (= 3
           (((add two one) inc) 0)))

    (is (= 4
           (((add two two) inc) 0)))))
