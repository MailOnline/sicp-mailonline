(ns sicp-mailonline.exercises.1-4-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-4 :refer :all]))

(deftest adding-to-abs
  (testing "look, can use operators"
    (is (= (a-plus-abs-b 1 2) 3))
    (is (= (a-plus-abs-b 1 -2) 3))))
