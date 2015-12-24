;
; Exercise 2.34
; 

(ns sicp-mailonline.exercises.2-34-test
  (require [sicp-mailonline.exercises.2-34 :refer :all]
           [clojure.test :refer :all]))

(deftest horner-eval-test
  (testing "Nils"
    (is (= (horner-eval 2 nil) 0)))

  (testing "Not nil"
    ; 32 + 40 + 6 + 1 = 79
    (is (= (horner-eval 2 (list 1 3 0 5 0 1)) 79))))

(run-tests)
