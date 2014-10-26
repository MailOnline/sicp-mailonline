(ns sicp-mailonline.paragraphs.1-1-6-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-6 :refer :all]))

(deftest absolutization
  (testing "always positive"
    (is (= (abs -21) 21))
    (is (= (abs 42) 42))
    (is (= (abs 0) 0)))
  (testing "same, but sing if statement"
    (is (= (abs -8) 8))
    (is (= (abs 166) 166))))

(deftest comparison
  (testing "self-implemented <="
    (is (le 8 8))
    (is (le 8 9))
    (is (not (le 9 8))))
  (testing "alternate comparison"
    (is (ge 9 0))
    (is (ge 9 9))
    (is (not (ge 9 10)))))
