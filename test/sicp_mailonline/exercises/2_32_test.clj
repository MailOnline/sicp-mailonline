
;
;Exercise 2.32
; 

(ns sicp-mailonline.exercises.2-32-test
  (require [sicp-mailonline.exercises.2-32 :refer :all]
           [clojure.test :refer :all]))


(deftest subsets-test
  (testing "nil and empty")
    (is (= (subsets nil) '(()) )
    (is (= (subsets '()) '(()) )))

  (testing "set 1,2,3"
    (is (= (subsets '(1 2 3)) '(() (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3)) ))))

(run-tests)
