;; Example 2.3.3

(ns sicp-mailonline.examples.2-3-3-test.unordered
  (:require [sicp-mailonline.examples.2-3-3.unordered :refer :all]
            [clojure.test :refer :all]))

(deftest sets-as-unordered-lists
  (testing "element-of-set?"
    (is (not (element-of-set? :elem '())))
    (is (not (element-of-set? :elem '(:not-elem))))
    (is (element-of-set? :elem '(:elem)))
    (is (element-of-set? :elem '(:not-elem :elem))))

  (testing "adjoin-set"
    (is (= '(:elem)
           (adjoin-set :elem '())))

    (is (= '(:elem)
           (adjoin-set :elem '(:elem))))

    (is (= '(:elem :not-elem)
           (adjoin-set :elem '(:not-elem)))))

  (testing "intersection-set"
    (is (empty? (intersection-set '() '())))
    (is (empty? (intersection-set '(:elem) '())))
    (is (empty? (intersection-set '() '(:elem))))
    (is (empty? (intersection-set '(:not-elem) '(:elem))))

    (is (= '(:elem)
           (intersection-set '(:elem) '(:elem))))

    (is (= '(:elem)
           (intersection-set '(:elem :x) '(:y :elem))))))
