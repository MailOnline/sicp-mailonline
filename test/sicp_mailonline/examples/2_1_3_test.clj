;; Example 2.1.3

(ns sicp-mailonline.examples.2-1-3-test
  (:require [sicp-mailonline.examples.2-1-3 :refer :all]
            [clojure.test :refer :all]))

(deftest example2-1-3
  (testing "representing a pair without using a data structure"
    (let [pair (cons :x :y)]
      (is (= :x
             (car pair)))

      (is (= :y
             (cdr pair)))))

  (testing "invalid arguments"
    (let [pair (cons :x :y)]
      (is (thrown? IllegalArgumentException (pair -1)))
      (is (thrown? IllegalArgumentException (pair 2))))))
