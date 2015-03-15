;; Exercise 2.38

(ns sicp-mailonline.exercises.2-38-test
  (:require [sicp-mailonline.exercises.2-38 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const values (list 1 2 3))

(deftest exercise2-38
  (testing "fold-right division"
    (is (= 3/2
           (fold-right / 1 values))))

  (testing "fold-left division"
    (is (= 1/6
           (fold-left / 1 values))))

  (testing "fold-right list"
    (is (= '(1 (2 (3 ())))
           (fold-right list '() values))))

  (testing "fold-left list"
    (is (= '(((() 1) 2) 3)
           (fold-left list '() values))))

  (testing "commutative operations fold left and right to the same result"
    (is (= 6
           (fold-right + 0 values)
           (fold-left + 0 values))))

  (testing "non-commutative operations do not fold left and right to the same result"
    (is (not= (fold-right - 0 values)
              (fold-left - 0 values)))))
