(ns sicp-mailonline.exercises.1-12-test
  (:require [sicp-mailonline.exercises.1-12 :refer :all]
            [clojure.test :refer :all]))

;;           1
;;         1   1
;;       1   2   1
;;     1   3   3   1
;;   1   4   6   4   1
(deftest exercise1-12
  (testing "Pascal's triangle"
    (are [x y t] (= t (pascal-triangle x y))
          1 1 1
          1 2 1
          2 2 1
          1 3 1
          2 3 2
          3 3 1
          1 4 1
          2 4 3
          3 4 3
          4 4 1
          1 5 1
          2 5 4
          3 5 6
          4 5 4
          5 5 1)))
