(ns sicp-mailonline.exercises.3-12
  (:require [sicp-mailonline.mutable]))

(defn append [x y]
  (if (nil? x)
    y
    (cons (first x) (append (next x) y))))

(defn last-pair [x]
  (if (nil? (.cdr x))
    x
    (last-pair (.cdr x))))

(defn append! [x y]
  (.setcdr (last-pair x) y)
  x)
