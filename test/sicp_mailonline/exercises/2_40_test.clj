;; Exercise 2.40

(ns sicp-mailonline.exercises.2-40-test
  (:require [sicp-mailonline.exercises.2-40 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-40
  (testing "unique-pairs"
    (is (= '((2 1))
           (unique-pairs 2)))

    (is (= '((2 1) (3 1) (3 2))
           (unique-pairs 3)))

    (is (= '((2 1) (3 1) (3 2) (4 1) (4 2) (4 3))
           (unique-pairs 4))))

  (testing "prime-sum-pairs"
    (is (= '((2 1 3) (3 2 5) (4 1 5) (4 3 7) (5 2 7) (6 1 7) (6 5 11))
           (prime-sum-pairs 6)))))
