;; Exercise 1.41

(ns sicp-mailonline.exercises.1-41-test
  (:require [sicp-mailonline.exercises.1-41 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise1-41
  (testing "double inc"
    (are [x] (= (+ x 2) ((double inc) x))
         -2
          1
          0
          1
          2))

  (testing "the value returned by (((double (double double)) inc) 5)"
    (is (= 21
           (((double (double double)) inc) 5)))))
