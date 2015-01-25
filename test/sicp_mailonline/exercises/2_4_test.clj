;; Exercise 2.4

(ns sicp-mailonline.exercises.2-4-test
  (:require [sicp-mailonline.exercises.2-4 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-4
  (testing "procedural representation of pairs"
    (let [pair (cons :x :y)]
      (is (= :x (car pair)))
      (is (= :y (cdr pair))))))


;; (car pair)
;; (car (cons :x :y))
;; (car (fn [m] (m :x :y)))
;; ((fn [m] (m :x :y)) (fn [p q] p))
;; ((fn [p q] p) :x :y)
;; => :x

;; (cdr pair)
;; (cdr (cons :x :y))
;; (cdr (fn [m] (m :x :y)))
;; ((fn [m] (m :x :y)) (fn [p q] q))
;; ((fn [p q] q) :x :y)
;; => :y
