;
;Exercise 2.27
; 

(ns sicp-mailonline.exercises.2-27-test
  (require [sicp-mailonline.exercises.2-27 :refer :all]
           [clojure.test :refer :all]))


(deftest deep-reverse-test
  (testing "nil and empty lists"
    (is (empty? (deep-reverse nil)))
    (is (empty? (deep-reverse '()))))

  (testing "single elements"
    (is (= (deep-reverse 3) 3)))

  (testing "non-nested lists"
    (is (= (deep-reverse '(1 2)) '(2 1))))

  (testing "nested lists"
    (is (= (deep-reverse '((1 2) (3 4)))      '((4 3) (2 1))))
    (is (= (deep-reverse '((1 (5 8)) (3 4)))  '((4 3) ((8 5) 1))))))

(run-tests)
