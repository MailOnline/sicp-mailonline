(ns sicp-mailonline.exercises.2-2.test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-2 :refer :all]))

(deftest make-point-test
  (testing "make-point"
    (is (= (make-point 2 3) '(2 3)))))

(deftest x-point-test
  (testing "x-point"
    (is (= (x-point (make-point 2 3)) 2))))

(deftest midpoint-segment-test
  (testing "midpoint-segment"
    (is (= (midpoint-segment 
              (make-segment 
                (make-point 2 3)
                (make-point 4 5)))
            '(3 4)))))


(run-tests)
