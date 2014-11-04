(ns sicp-mailonline.exercises.1-7-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-7 :refer :all]
            [sicp-mailonline.exercises.1-7 :refer :all]))

(deftest good-enough-small-numbers
  (testing "the good-enough? method fails on small numbers"
    (is (not (= (. Math sqrt 0.001) (sqrt 0.001))))))

; Causes a stack overflow
;(deftest good-enough-big-numbers
;  (testing "the good-enough? method fails on big numbers"
;    (let [big-num (. Math pow 10 13)]
;      (is (not (= (. Math sqrt big-num) (sqrt big-num)))))))

(deftest test-better-sqrt
  (testing "the better square root method has improved accuracy"
    (is (= (. Math sqrt 0.001) (better-sqrt 0.001)))))

