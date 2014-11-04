(ns sicp-mailonline.exercises.1-7-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-7 :refer :all]
            [sicp-mailonline.exercises.1-7 :refer :all]))

(deftest good-enough-small-numbers
  (testing "the good-enough? method fails on small numbers"
    (is (not (= (. Math sqrt 0.001) (sqrt 0.001))))))

(deftest good-enough-big-numbers
  (testing "the good-enough? method fails on big numbers"
    (let [big-num (+ (. Math pow 10 12) (. Math PI))]
      (is (zero? (. Float compare (. Math sqrt big-num) (sqrt big-num)))))))

(deftest test-better-sqrt
  (testing "the better square root method has improved accuracy"
    (is (= (. Math sqrt 0.001) (better-sqrt 0.001)))
    (is (= 13.0 (better-sqrt 169)))))

