;; Exercise 2.25
;; Give the combinations of cars and cdrs that will pick 7 from each of the
;; following lists:
;;   (1 3 (5 7) 9)
;;   ((7))
;;   (1 (2 (3 (4 (5 (6 7))))))

(ns sicp-mailonline.exercises.2-25-test
  (:require [clojure.test :refer :all]))

(deftest exercise2-25
  (testing "(1 3 (5 7) 9)"
    (let [x (list 1 3 '(5 7) 9)]
      (is (= 7
             (first (rest (first (rest (rest x)))))))))

  (testing "((7))"
    (let [x (list '(7))]
      (is (= 7
             (first (first x))))))

  (testing "(1 (2 (3 (4 (5 (6 7))))))"
    (let [x (list 1 '(2 (3 (4 (5 (6 7))))))]
      (is (= 7
             (first (rest
                     (first (rest
                             (first (rest
                                     (first (rest
                                             (first (rest
                                                     (first (rest x)))))))))))))))))
