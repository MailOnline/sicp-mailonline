(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest gcd-test
  (testing "gcd"
    (is (= (gcd 40 206) 2))))

(deftest make-rat-test
  (testing "make-rat"
    (is (= (make-rat 4 6) '(2 3)))
    (is (= (make-rat -4 6) '(-2 3)))
    (is (= (make-rat 4 -6) '(-2 3)))
    (is (= (make-rat -4 -6) '(2 3)))))

(run-all-tests)
