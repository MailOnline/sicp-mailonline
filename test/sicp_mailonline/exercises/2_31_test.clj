;
;Exercise 2.31
; 
(ns sicp-mailonline.exercises.2-31-test
  (require [sicp-mailonline.exercises.2-31 :refer :all]
           [clojure.test :refer :all]))

(def tree '(1 (2 (3 4) 5) (6 7)))

(def expected '(1 (4 (9 16) 25) (36 49)))

(deftest square-tree-test
  (testing "square-tree"
    (is (= (square-tree tree) expected))))

(run-tests)
