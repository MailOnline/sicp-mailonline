;; Exercise 1.44
;; The idea of smoothing a function is an important concept in signal processing.
;; If f is a function and dx is some small number, then the smoothed version of
;; f is the function whose value at a point x is the average of f(x - dx), f(x),
;; and f(x + dx).
;; Write a procedure smooth that takes as input a procedure that computes f and
;; returns a procedure that computes the smoothed f.  It is sometimes valuable
;; to repeatedly smooth a function (that is, smooth the smoothed function, and
;; so on) to obtain the n-folded smoothed function.  Show how to generate the
;; n-fold smoothed function of any given function using smooth and repeated from
;; exercise 1.43.

(ns sicp-mailonline.exercises.1-44
  (:require [sicp-mailonline.exercises.1-43 :refer [repeated]]))

(def ^:private ^:const dx 0.00001)

(defn smooth [f]
  (letfn [(average [a b c] (/ (+ a b c) 3))]
    (fn [x] (average (f (- x dx))
                     (f x)
                     (f (+ x dx))))))

(defn n-fold-smooth [f n]
  ((repeated smooth n) f))
