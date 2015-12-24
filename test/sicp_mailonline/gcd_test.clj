(ns sicp-mailonline.gcd-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.gcd :refer :all]))

(deftest gcd-test
  (testing "gcd"
    (is (= (gcd 40 206) 2))))

(run-tests)