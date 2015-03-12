;; Exercise 2.30

(ns sicp-mailonline.exercises.2-30-test
  (:require [sicp-mailonline.exercises.2-30 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const tree (list 1 (list 2 (list 3 4) 5) (list 6 7)))

(defn- test-square-tree [square-tree]
  (testing "square-tree"
    (is (= '(1 (4 (9 16) 25) (36 49))
           (square-tree tree)))))

(deftest exercise2-30
  (testing "direct implementation"
    (test-square-tree square-tree-a))

  (testing "using map and recursion"
    (test-square-tree square-tree-b)))
