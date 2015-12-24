;
; Exercise 2.35
; 

(ns sicp-mailonline.exercises.2-35-test
  (require [sicp-mailonline.exercises.2-35 :refer :all]
           [clojure.test :refer :all]))

(def x (cons (list 1 2) (list 3 4)))

(deftest count-leaves-test
  (testing "Nil"
    (is (= (count-leaves nil) 0)))

  (testing "Non-nil"
    (is (= (count-leaves x) 4))))


(run-tests)

