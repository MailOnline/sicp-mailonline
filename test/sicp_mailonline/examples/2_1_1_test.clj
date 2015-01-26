;; Example 2.1.1

(ns sicp-mailonline.examples.2-1-1-test
  (:require [sicp-mailonline.examples.2-1-1 :refer :all]
            [clojure.test :refer :all]))

(deftest example2-1-1
  (testing "rational numbers"
    (let [one-half (make-rat 1 2)
          one-third (make-rat 1 3)]

      (is (equal-rat? (make-rat 5 6)
                      (add-rat one-half one-third)))

      (is (equal-rat? (make-rat 1 6)
                      (mul-rat one-half one-third)))

      (is (equal-rat? (make-rat 2 3)
                      (add-rat one-third one-third))))))
