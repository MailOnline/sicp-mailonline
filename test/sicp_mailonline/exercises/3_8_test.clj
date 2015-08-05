;
; Exercise 3.8
;
(ns sicp-mailonline.exercises.3-8-test   
  (:require   [clojure.test :refer :all]
              [sicp-mailonline.exercises.3-8 :refer :all]))

(deftest make-f-test 
  (testing "Evaluation order dependent"
    (let [f1 (make-f)
          f2 (make-f)]
          (is (= (+ (f1 0) (f1 1))  8)) 
          (is (= (+ (f2 1) (f2 0))  7)))))

(run-tests)
