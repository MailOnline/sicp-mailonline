;; Exercise 2.3

(ns sicp-mailonline.exercises.2-3-test
  (:require [sicp-mailonline.exercises.2-3 :refer :all]
            [sicp-mailonline.exercises.2-2 :refer [make-point]]
            [clojure.test :refer :all]))

(deftest exercise2-3
  (testing "RectangleImpl1 positive quadrant"
    (let [rectangle (make-rectangle1 (make-point 0 0) (make-point 4 2))]
      (is (= 2 (height rectangle)))
      (is (= 4 (width rectangle)))
      (is (= 12 (perimeter rectangle)))
      (is (= 8 (area rectangle)))))

  (testing "RectangleImpl1 negative quadrant"
    (let [rectangle (make-rectangle1 (make-point -5 -3) (make-point 0 0))]
      (is (= 3 (height rectangle)))
      (is (= 5 (width rectangle)))
      (is (= 16 (perimeter rectangle)))
      (is (= 15 (area rectangle)))))

  (testing "RectangleImpl2 positive quadrant"
    (let [rectangle (make-rectangle2 (make-point 0 0) 2 4)]
      (is (= 2 (height rectangle)))
      (is (= 4 (width rectangle)))
      (is (= 12 (perimeter rectangle)))
      (is (= 8 (area rectangle)))))

  (testing "RectangleImpl2 negative quadrant"
    (let [rectangle (make-rectangle2 (make-point -5 -3) 3 5)]
      (is (= 3 (height rectangle)))
      (is (= 5 (width rectangle)))
      (is (= 16 (perimeter rectangle)))
      (is (= 15 (area rectangle))))))
