
;
;Exercise 2.30
; 

(ns sicp-mailonline.exercises.2-30-test
  (require [sicp-mailonline.exercises.2-30 :refer :all]
           [clojure.test :refer :all]))

(def tree '(1 (2 (3 4) 5) (6 7)))

(def expected '(1 (4 (9 16) 25) (36 49)))

(deftest square-tree-test
  (testing "square-tree-1"
    (is (= (square-tree-1 tree) expected)))
  (testing "square-tree-2"
    (is (= (square-tree-2 tree) expected))))

(run-tests)