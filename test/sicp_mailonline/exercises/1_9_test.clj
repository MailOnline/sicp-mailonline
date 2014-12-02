(ns sicp-mailonline.exercises.1-9-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-9 :refer :all]))

(deftest test-sum-with-inc
  (testing "Sum with inc method adds two numbers correctly"
    (is (= 5 (sum-with-inc 2 3)))
    (is (= -5 (sum-with-inc -8 3)))
    (is (= 3 (sum-with-inc 0 3)))))

(deftest test-sum-with-dec
  (testing "Sum with dec method adds two numbers correctly"
    (is (= 5 (sum-with-dec 2 3)))
    (is (= -5 (sum-with-dec -8 3)))
    (is (= 3 (sum-with-dec 0 3)))))
