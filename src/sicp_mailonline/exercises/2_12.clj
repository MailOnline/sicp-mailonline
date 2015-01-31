;; Exercise 2.12
;; Define a constructor make-center-percent that takes a center and a percentage
;; tolerance and produces the desired interval.  You must also define a selector
;; percent that produces the percentage tolerance for a given interval.  The
;; center selector is the same as the one shown above.

(ns sicp-mailonline.exercises.2-12
  (:require [sicp-mailonline.exercises.2-7 :refer :all]))

;; Prior to this exercise, the example is refined to a program that can deal with
;; numbers represented as a center value and an additive tolerance, for example
;; 3.5 +- 0.15 rather than [3.35, 3.65] as follows:

(defn make-center-width [c w]
  (make-interval (- c w) (+ c w)))

(defn center [i]
  (/ (+ (lower-bound i) (upper-bound i))
     2))

(defn width [i]
  (/ (- (upper-bound i) (lower-bound i))
     2))


;; Exercise solution follows

(defn make-center-percent [center percent]
  (let [width (* center (/ percent 100M))]
    (make-center-width center width)))

(defn percent [interval]
  (* 100M
     (/ (width interval) (center interval))))
