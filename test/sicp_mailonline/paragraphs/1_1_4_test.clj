(ns sicp-mailonline.paragraphs.1-1-4-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-4 :refer :all]
            [sicp-mailonline.utils :refer :all]))

(deftest squaring
  (testing "simple"
      (is (= (square 21) 441))
      (is (= (square (+ 2 5)) 49))
      (is (= (square (square 3)) 81)))
  (testing "sum of squares"
      (is (= (sum-of-squares 3 4) 25))
      (is (= (f 5) 136))))
