;; Exercise 1.46

(ns sicp-mailonline.exercises.1-46-test
  (:require [sicp-mailonline.exercises.1-46 :refer :all]
            [clojure.test :refer :all]))

(defn- square [n]
  (* n n))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.00001))

(deftest exercise1-46
  (testing "sqrt via iterative-improve"
    ;; test cases taken from section 1.1.7
    (is (close-to? 3.00009
                   (sqrt 9)))

    (is (close-to? 11.70469
                   (sqrt (+ 100 37))))
    
    (is (close-to? 1.77392
                   (sqrt (+ (sqrt 2) (sqrt 3)))))

    (is (close-to? 1000.00036
                   (square (sqrt 1000)))))

  (testing "fixed-point via iterative-improve"
    ;; test cases taken from section 1.3.3
    (is (close-to? 0.73908
                   (fixed-point (fn [y] (Math/cos y)))))

    (is (close-to? 1.25873
                   (fixed-point (fn [y] (+ (Math/sin y) (Math/cos y))))))))
