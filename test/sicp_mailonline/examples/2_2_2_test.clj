;; 2.2.2 Hierarchical Structures

(ns sicp-mailonline.examples.2-2-2-test
  (:require [sicp-mailonline.examples.2-2-2 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const x (cons (list 1 2) (list 3 4)))

(deftest example2-2-2
  (testing "count-leaves"
    (is (= 4
           (count-leaves x)))

    (is (= 8
           (count-leaves (list x x))))

    (is (= 0
           (count-leaves '())))

    (is (= 1
           (count-leaves (list 7))))))
