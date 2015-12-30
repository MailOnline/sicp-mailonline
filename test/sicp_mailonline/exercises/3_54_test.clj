;; Exercise 3.54

(ns sicp-mailonline.exercises.3-54-test
  (:require [sicp-mailonline.examples.3-5-1 :as strm]
            [sicp-mailonline.exercises.3-54 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise3-54
  (testing "factorials"
    (are [n f]
        (= f (strm/stream-ref factorials n))
       1       1
       5     120
      10 3628800)))
