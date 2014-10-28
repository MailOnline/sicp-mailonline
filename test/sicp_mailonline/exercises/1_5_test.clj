(ns sicp-mailonline.exercises.1-5-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-5 :refer :all]))

(deftest ex-1-5
  (testing "simulate lazy params evaluation, Clj is applicative order"
    (is (= (test-lazy 0 (delay (p)))))))
