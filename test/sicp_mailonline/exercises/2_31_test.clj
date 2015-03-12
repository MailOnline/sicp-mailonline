;; Exercise 2.31

(ns sicp-mailonline.exercises.2-31-test
  (:require [sicp-mailonline.exercises.2-31 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const tree (list 1 (list 2 (list 3 4) 5) (list 6 7)))

(defn- test-tree-map-square-tree [tree-map]
  (testing "square-tree using tree-map"
    (letfn [(square [n] (* n n))]      
      (is (= '(1 (4 (9 16) 25) (36 49))
             (tree-map square tree))))))

(deftest exercise2-31
  (testing "direct implementation"
    (test-tree-map-square-tree tree-map-a))

  (testing "using map and recursion"
    (test-tree-map-square-tree tree-map-b)))
