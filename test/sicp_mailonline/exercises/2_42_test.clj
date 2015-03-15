;; Exercise 2.42

(ns sicp-mailonline.exercises.2-42-test
  (:require [sicp-mailonline.exercises.2-42 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-42
  (testing "empty board"
    (is (= '())
        (queens 0)))
  
  (testing "1 queen on 1x1 chessboard"
    (is (= '(((1 1)))
           (queens 1))))

  (testing "no solution exists for 2x2 chessboard"
    (is (= '())
        (queens 2)))

  (testing "no solution exists for 3x3 chessboard"
    (is (= '())
        (queens 3)))

  (testing "4 queens on 4x4 chessboard"
    (is (= '#{((4 3) (3 1) (2 4) (1 2))
              ((4 2) (3 4) (2 1) (1 3))}
           (set (queens 4)))))

  (testing "solution counts"
    ;; see https://en.wikipedia.org/wiki/Eight_queens_puzzle
    (are [n solution-count] (= solution-count (count (queens n)))
          5  10
          6   4
          7  40
          8  92
          9 352)))
