;
; Exercise 2.36
; 

(ns sicp-mailonline.exercises.2-36-test
  (require [sicp-mailonline.exercises.2-36 :refer :all]
           [clojure.test :refer :all]))

(def s '((1 2 3) (4 5 6) (7 8 9) (10 11 12)))

(deftest s-accumulate-n-test
  (testing "nil"
    (is (empty? (s-accumulate-n + 0 nil))))

  (testing "not nil"
    (is (= (s-accumulate-n + 0 s) '(22 26 30)))))

(run-tests)
