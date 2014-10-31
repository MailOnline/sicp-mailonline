(ns sicp-mailonline.paragraphs.1-1-6-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-6 :refer :all]))

(deftest test-abs
  (testing "Absolute value"
    (is (= (abs 1) 1))
    (is (= (abs -1) 1))
    (is (= (abs 0) 0))))

