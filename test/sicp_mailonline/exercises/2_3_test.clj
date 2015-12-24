(ns sicp-mailonline.exercises.2-3.test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-3 :refer :all]))

(deftest make-point-test
  (testing "make-point"
    (is (= (make-point 2 3) '(2 3)))))

(deftest x-point-test
  (testing "x-point"
    (is (= (x-point (make-point 2 3)) 2))))

(deftest y-point-test
  (testing "y-point"
    (is (= (y-point (make-point 2 3)) 3))))

(deftest mr1-test
  (testing "make rectangle 1"
    (is (mr1 (make-point 2 3) (make-point 5 7)) 
        (list (list 2 3) (list 5 7)))))

(deftest sr1-test
  (testing "start rectangle 1"
    (is (sr1 (mr1 (make-point 2 3) (make-point 5 7))) '(2 3))))

(deftest er1-test
  (testing "end rectangle 1"
    (is (er1 (mr1 (make-point 2 3) (make-point 5 7))) '(5 7))))

(deftest mr2-test
  (testing "make rectangle 1"
    (is (mr2 (make-point 2 3) 5 7) 
        (list (list 2 3) 5 7))))

(deftest sr2-test
  (testing "make rectangle 2"
    (is (sr2 (mr2 (make-point 2 3) 5 7)) '(2 3))))

(deftest er2-test
  (testing "make rectangle 2"
    (is (er2 (mr2 (make-point 2 3) 5 7)) '(7 10))))

(deftest permimeter-test
  (testing "perimeter abstraction 1"
    (is (perimeter 
          sr1 er1 
          (mr1 (make-point 2 3) (make-point 5 7)))
        14))
  (testing "perimeter abstraction 2"
    (is   (perimeter
            sr2 er2
            (mr2 (make-point 2 3) 5 7))
          24)))

(deftest area-test
  (testing "area abstraction 1"
    (is (area
      sr1 er1
      (mr1 (make-point 2 3) (make-point 5 7)))
    12))
  (testing "area abstraction 2"
    (is (area
      sr2 er2
      (mr2 (make-point 2 3) 5 7))
    35)))

(run-tests)
