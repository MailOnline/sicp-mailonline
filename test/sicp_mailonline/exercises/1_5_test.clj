(ns sicp-mailonline.exercises.1-5-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-5 :refer :all]))

(deftest test-test_
  (testing "No stack overflow is caused as (p) is never evaluated"
      (try (test_ 0 (p))
           (catch Exception e (report "(p) was evaluated.")))))
