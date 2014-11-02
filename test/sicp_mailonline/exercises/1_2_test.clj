(ns sicp-mailonline.exercises.1-2-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-2 :refer :all]))

(deftest test-expression
  (testing "I correctly translated the expression into prefix form"
    (is (zero? (. Float compare expression (/ 14.8 -60))))))

