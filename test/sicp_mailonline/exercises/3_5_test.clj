;; Exercise 3.5

(ns sicp-mailonline.exercises.3-5-test
  (:require [sicp-mailonline.exercises.3-5 :refer :all]
            [clojure.test :refer :all]))

(defn- square [x]
  (* x x))

(defn- approx? [target value tolerance]
  (< (Math/abs (- target value)) tolerance))

(defn- make-area-predicate [centre-x centre-y r]
  (fn [x y] (<= (+ (square (- x centre-x))
                   (square (- y centre-y)))
                (square r))))

(deftest exercise3-5
  (testing "circle of radius 3 centred at (5,7)"
    (let [p (make-area-predicate 5 7 3)]
      (is (approx? 28.3
                   (estimate-integral p 2 8 4 10 100000)
                   0.1))))

  (testing "estimating pi by measuring the area of a unit circle"
    (let [p (make-area-predicate 1 1 1)]
      (is (approx? 3.14159
                   (estimate-integral p 0 2 0 2 100000)
                   0.01)))))
