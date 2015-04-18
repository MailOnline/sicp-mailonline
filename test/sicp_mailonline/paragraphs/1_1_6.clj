(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest abs-test
  (testing "Test abs"
    (is (= 2 (abs -2)))
    (is (= 0 (abs 0)))
    (is (= 3 (abs 3)))))

(deftest abs2-test
  (testing "Test abs"
    (is (= 2 (abs2 -2)))
    (is (= 0 (abs2 0)))
    (is (= 3 (abs2 3)))))


(deftest abs3-test
  (testing "Test abs"
    (is (= 2 (abs3 -2)))
    (is (= 0 (abs3 0)))
    (is (= 3 (abs3 3)))))


(run-all-tests)
