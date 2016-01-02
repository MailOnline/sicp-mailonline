;; Example 3.5.1

(ns sicp-mailonline.examples.3-5-1-test
  (:require [sicp-mailonline.examples.3-5-1 :refer :all]
            [sicp-mailonline.examples.1-2-6 :refer [prime?]]
            [clojure.test :refer :all]))

(deftest example3-5-1
  (testing "streams"
    (is (= 10009
           (stream-car
            (stream-cdr
             (stream-filter prime?
                            (stream-enumerate-interval 10000 1000000))))))))
