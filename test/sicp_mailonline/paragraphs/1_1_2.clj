(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest size-test
  (testing "Testing size"
    (is (= 2 size))))

(deftest pi-test
  (testing "PI test"
    (is (< (Math/abs (- pi 3.1415926)) 1e-5))))


(run-all-tests)