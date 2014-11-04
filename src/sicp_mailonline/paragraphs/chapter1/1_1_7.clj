(ns sicp-mailonline.paragraphs.chapter1.1-1-7
  (:require [sicp-mailonline.paragraphs.chapter1.1-1-4 :refer [square]]
            [sicp-mailonline.paragraphs.chapter1.1-1-6 :refer [abs]]))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))
