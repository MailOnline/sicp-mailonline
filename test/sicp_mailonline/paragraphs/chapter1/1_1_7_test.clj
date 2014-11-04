(ns sicp-mailonline.paragraphs.chapter1.1-1-7-test
  (:require [sicp-mailonline.paragraphs.chapter1.1-1-7 :refer :all]
            [sicp-mailonline.paragraphs.chapter1.1-1-4 :refer [square]]
            [sicp-mailonline.paragraphs.chapter1.1-1-6 :refer [abs]]
            [clojure.test :refer :all]))

(defn- within-tolerance [actual x]
  (< (abs (- (square actual) x)) 0.001))

(deftest test-sqrt-iter
  (testing "square root of 9"
    (is (within-tolerance (sqrt 9) 9)))
  (testing "square root of 1000"
    (is (within-tolerance (sqrt 1000) 1000))))
