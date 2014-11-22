(ns sicp-mailonline.examples.1-2-4-test
  (:require [sicp-mailonline.examples.1-2-4 :refer :all]
            [clojure.test :refer :all]))

(defn- test-exponent [f]
  (are [b n x] (= x (f b n))
        2 0 1
        2 1 2
        2 2 4
        2 3 8))
 
(deftest exponentiation
  (testing "exponentiation"
    (test-exponent rexpt)
    (test-exponent iexpt)
    (test-exponent fast-expt)))
