;
; Exercise 2.37
; 

(ns sicp-mailonline.exercises.2-37-test
  (require [sicp-mailonline.exercises.2-37 :refer :all]
           [clojure.test :refer :all]))

(deftest dot-product-test
  (testing "dot product"
    (is (= (dot-product '(1 2) '(3 4)) 11))))

(deftest matrix-*-vector-test
  (testing "matrix * vector"
    (is (= (matrix-*-vector '((1 2) (3 4)) '(5 7)) 
                            '(19 43)))))

(deftest transpose-test
  (testing "transpose matrix"
    (is (= (transpose '((1 2) (3 4))) 
                      '((1 3) (2 4))))))

(deftest matrix-*-matrix-test
  (testing "matrix * matrix"
    ; (1 2) (5 6)  =  (1*5+2*7 1*6+2*8)  = (19 22)
    ; (3 4) (7 8)  =  (3*5+4*7 3*6+4*8)  = (43 50)
    (is (= (matrix-*-matrix '((1 2) (3 4)) '((5 6) (7 8))) 
                            '((19 22) (43 50))))))

(run-tests)
