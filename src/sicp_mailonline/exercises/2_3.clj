(ns sicp-mailonline.exercises.2-3
  (:require [sicp-mailonline.exercises.2-2 :refer :all]))

(defn make-rectangle [p1 p2 p3 p4] [p1 p2 p3 p4])
(defn height [[p1 p2 p3 p4]] (length-segment p2 p3))
(defn width [[p1 p2 p3 p4]] (length-segment p1 p2))

(defn perimeter [r]
  (* 2 (+ (height r) (width r))))

(defn area [r]
  (* (height r) (width r)))
