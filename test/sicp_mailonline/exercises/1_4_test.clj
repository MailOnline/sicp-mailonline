(ns sicp-mailonline.exercises.1-4-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-4 :refer :all]))

(deftest test-a-plus-abs-b
  (testing "The method returns a plus the absolute value of b"
    (is (= (a-plus-abs-b 1 -1) 2))
    (is (= (a-plus-abs-b 1 1) 2))
    (is (= (a-plus-abs-b -1 -1) 0))
  ))

