;; Exercise 3.1

(ns sicp-mailonline.exercises.3-1-test
  (:require [sicp-mailonline.exercises.3-1 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise3-1
  (testing "make-accumulator"
    (let [a (make-accumulator 5)]
      (is (= 15 (a 10)))
      (is (= 25 (a 10))))))
