;; 2.2.2 Hierarchical Structures

(ns sicp-mailonline.examples.2-2-2-test
  (:require [sicp-mailonline.examples.2-2-2 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const x (cons (list 1 2) (list 3 4)))
(def ^:private ^:const tree (list 1 (list 2 (list 3 4) 5) (list 6 7)))

(deftest example2-2-2
  (testing "count-leaves"
    (is (= 4
           (count-leaves x)))

    (is (= 8
           (count-leaves (list x x))))

    (is (= 0
           (count-leaves '())))

    (is (= 1
           (count-leaves (list 7)))))
  
  (testing "recursive scale-tree"
    (is (= '(10 (20 (30 40) 50) (60 70))
           (recursive-scale-tree tree 10))))

  (testing "map scale-tree"
    (is (= '(10 (20 (30 40) 50) (60 70))
           (map-scale-tree tree 10)))))
