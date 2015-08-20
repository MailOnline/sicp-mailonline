;
;Exercise 2.28
; 

(ns sicp-mailonline.exercises.2-28-test
  (require [sicp-mailonline.exercises.2-28 :refer :all]
           [clojure.test :refer :all]))

(deftest fringe-test
  (testing "Nil and empty lists"
    (is (nil? (fringe nil)))
    (is (nil? (fringe '()))))

  (testing "Unnested and nested lists"
    (is (fringe (list 1 2 3 4)) '(1 2 3 4))
    (is (fringe (list (list 3 4) (list 1 2) 7)) '(3 4 1 2 7))))

(run-tests)
