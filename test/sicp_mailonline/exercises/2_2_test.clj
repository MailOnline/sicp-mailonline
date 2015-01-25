;; Exercise 2.2

(ns sicp-mailonline.exercises.2-2-test
  (:require [sicp-mailonline.exercises.2-2 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const origin (make-point 0 0))

(defn- eq-point? [x y point]
  (and (= x (x-point point))
       (= y (y-point point))))

(deftest exercise2-2
  ;; 4         e    
  ;; 3
  ;; 2     m
  ;; 1
  ;; 0 s       
  ;;   0 1 2 3 4
  (testing "positive x positive y"
    (let [end (make-point 4 4)]
      (is (eq-point? 2 2
                     (midpoint-segment (make-segment origin end))))))

  ;;    0 1 2 3 4
  ;;  0 s
  ;; -1
  ;; -2     m
  ;; -3
  ;; -4         e
  (testing "positive x negative y"
    (let [end (make-point 4 -4)]
      (is (eq-point? 2 -2
                     (midpoint-segment (make-segment origin end))))))

  ;; -4 -3 -2 -1  0
  ;;              s  0
  ;;                -1
  ;;        m       -2
  ;;                -3
  ;;  e             -4
  (testing "negative x negative y"
    (let [end (make-point -4 -4)]
      (is (eq-point? -2 -2
                     (midpoint-segment (make-segment origin end))))))

  ;;  e             4
  ;;                3
  ;;        m       2
  ;;                1
  ;;              s 0
  ;; -4 -3 -2 -1  0
  (testing "negative x positive y"
    (let [end (make-point -4 4)]
      (is (eq-point? -2 2
                     (midpoint-segment (make-segment origin end)))))))
