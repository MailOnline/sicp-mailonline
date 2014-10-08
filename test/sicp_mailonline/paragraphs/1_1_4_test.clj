(ns sicp-mailonline.paragraphs.1-1-4-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-4 :refer :all]))

(deftest test-sum-squares
  (testing "Sum of squares"
    (is (= (sum-squares 5 3) 34))))

