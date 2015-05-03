;; Exercise 2.68

(ns sicp-mailonline.exercises.2-68-test
  (:require [sicp-mailonline.exercises.2-68 :refer :all]
            [sicp-mailonline.exercises.2-67-test :refer [sample-tree sample-message]]
            [clojure.test :refer :all]))

(deftest exercise2-68
  (testing "encoding the decoded sample message gives the sample message"
    (is (= sample-message
           (encode '(A D A B B C A) sample-tree))))

  (testing "cannot encode an unrecognised symbol"
    (is (thrown? IllegalArgumentException
                 (encode '(E))))))
