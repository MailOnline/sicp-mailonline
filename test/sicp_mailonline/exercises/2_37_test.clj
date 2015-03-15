;; Exercise 2.37

(ns sicp-mailonline.exercises.2-37-test
  (:require [sicp-mailonline.exercises.2-37 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-37
  (testing "dot-product"
    (is (= 70
           (dot-product '(1 2 3 4)
                        '(5 6 7 8)))))

  (testing "matrix-*-vector"
    (is (= '(70 140 200)
           (matrix-*-vector '((1 2 3 4)
                              (4 5 6 6)
                              (6 7 8 9))
                            '(5 6 7 8)))))
  
  (testing "transpose"
    (is (= '((1 4 6)
             (2 5 7)
             (3 6 8)
             (4 6 9))
           (transpose '((1 2 3 4)
                        (4 5 6 6)
                        (6 7 8 9))))))

  (testing "matrix-*-matrix"
    (is (= '((58 64) (139 154))
           (matrix-*-matrix '((1 2 3)
                              (4 5 6))
                            '((7 8)
                              (9 10)
                              (11 12)))))))
