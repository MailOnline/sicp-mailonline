;; Exercise 1.30

(ns sicp-mailonline.exercises.1-30-test
  (:require [sicp-mailonline.exercises.1-30 :refer [sum]]
            [clojure.test :refer :all]))

;; the following sum clients are taken from example 1.3.1
(defn- cube [x]
  (* x x x ))

(defn- sum-cubes [a b]
  (sum cube a inc b))

(defn- sum-integers [a b]
  (sum identity a inc b))

(defn- pi-sum [a b]
  (letfn [(pi-term [x] (/ 1.0 (* x (+ x 2))))
          (pi-next [x] (+ x 4))]
    (sum pi-term a pi-next b)))

(defn- integral [f a b dx]
  (letfn [(add-dx [x] (+ x dx))]
    (* (sum f (+ a (/ dx 2.0)) add-dx b)
       dx)))

(defn- close-to? [x y]
  (< (Math/abs (- x y)) 0.0000000001))

(deftest exercise1-30
  (testing "sum cubes"
    (is (= 3025
           (sum-cubes 1 10))))

  (testing "sum integers"
    (is (= 55
           (sum-integers 1 10))))

  (testing "an approximation to pi"
    (is (close-to? 3.139592655589783
           (* 8 (pi-sum 1 1000)))))

  (testing "integral of cube between 0 and 1"
    (are [x y] (close-to? y (integral cube 0 1 x))
         0.01  0.24998750000000042
         0.001 0.249999875000001)))
