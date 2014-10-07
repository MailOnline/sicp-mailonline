(ns sicp-mailonline.paragraphs.1-1-4-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-4 :refer :all]))

(deftest square-number
  (testing "Should square the number"
    (is (= (square 2) 4))))
