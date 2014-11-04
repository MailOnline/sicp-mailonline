(ns sicp-mailonline.exercises.chapter1.1-8-test
  (:require [sicp-mailonline.exercises.chapter1.1-8 :refer :all]
            [sicp-mailonline.paragraphs.chapter1.1-1-6 :refer [abs]]
            [clojure.test :refer :all]))

(defn- within-tolerance [actual x]
  (< (abs (- (cube actual) x)) 0.001))

(deftest test-cube-root
  (testing "cube root of 27"
    (is (within-tolerance (cube-root 27) 27)))
  (testing "cube root of 1000"
        (is (within-tolerance (cube-root 1000) 1000))))
