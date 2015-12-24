
;
;Exercise 2.29
; 

(ns sicp-mailonline.exercises.2-29-test
  (require [sicp-mailonline.exercises.2-29 :refer :all]
           [clojure.test :refer :all]))


(def m1 (make-mobile (make-branch 4 5) (make-branch 5 4))) 

(def m2 (make-mobile (make-branch 4 5) (make-branch 5 (make-mobile (make-branch 1 2) (make-branch 3 4)))))

(deftest total-weight-test
	(testing "Correct weight"
		(is (= (total-weight m1) 9))
    (is (= (total-weight m2) 11))))

(deftest is-balanced-ted
  (testing "balanced")
    (is (is-balanced? m1))

   (testing "unbalanced"
    (is (not (is-balanced? m2)))))


(run-tests)
