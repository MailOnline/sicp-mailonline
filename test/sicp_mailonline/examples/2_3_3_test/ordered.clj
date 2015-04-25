;; Example 2.3.3

(ns sicp-mailonline.examples.2-3-3-test.ordered
  (:require [sicp-mailonline.examples.2-3-3.ordered :refer :all]
            [clojure.test :refer :all]))

(deftest sets-as-ordered-lists
  (testing "element-of-set?"
    (is (not (element-of-set? 42 '())))
    (is (not (element-of-set? 42 '(99))))
    (is (element-of-set? 42 '(42)))
    (is (element-of-set? 99 '(42 99))))

  (testing "intersection-set"
    (is (empty? (intersection-set '() '())))
    (is (empty? (intersection-set '(42) '())))
    (is (empty? (intersection-set '() '(42))))
    (is (empty? (intersection-set '(42) '(99))))

    (is (= '(42)
           (intersection-set '(42) '(42))))

    (is (= '(42)
           (intersection-set '(42 99) '(11 42))))))
