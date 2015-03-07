;; Exercise 2.28

(ns sicp-mailonline.exercises.2-28-test
  (:require [sicp-mailonline.exercises.2-28 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const x (list (list 1 2) (list 3 4)))

(deftest exercise2-28
  (testing "fringe"
    (is (= '(1 2 3 4)
           (fringe x)))

    (is (= '(1 2 3 4 1 2 3 4)
           (fringe (list x x))))

    (is (= '(1 2 3 4 5 6)
           (fringe (list 1 (list 2 (list 3 4) 5) 6))))))
