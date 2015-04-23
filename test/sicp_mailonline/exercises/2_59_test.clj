;; Exercise 2.59

(ns sicp-mailonline.exercises.2-59-test
  (:require [sicp-mailonline.exercises.2-59 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-59
  (testing "union-set"
    (is (empty? (union-set '() '())))

    (is (= '(:elem)
           (union-set '(:elem) '())))

    (is (= '(:elem)
           (union-set '() '(:elem))))

    (is (= '(:elem)
           (union-set '(:elem) '(:elem))))

    (is (= '(:elem :not-elem)
           (union-set '(:elem) '(:not-elem))))))
