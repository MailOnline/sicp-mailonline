(ns sicp-mailonline.exercises.chapter1.1-8
  (:require [sicp-mailonline.paragraphs.chapter1.1-1-4 :refer [square]]
            [sicp-mailonline.paragraphs.chapter1.1-1-6 :refer [abs]]))

(defn cube [x]
  (* x x x))

(defn improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(defn good-enough? [guess x]
  (< (abs (- (cube guess) x)) 0.001))

(defn cubert-iter [guess x]
  (if (good-enough? guess x)
    guess
    (cubert-iter (improve guess x)
                 x)))

(defn cube-root [x]
  (cubert-iter 1.0 x))
