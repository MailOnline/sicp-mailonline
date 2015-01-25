;; Exercise 2.3
;; Implement a representation for rectangles in a plane.  (Hint: You may want to
;; make use of exercise 2.2.)  In terms of your constructors and selectors,
;; create procedures that compute the perimeter and the area of a given rectangle.
;; Now implement a different representation for rectangles.  Can you design your
;; system with suitable abstraction barriers, so that the same perimeter and area
;; procedures will work using either representation?

(ns sicp-mailonline.exercises.2-3
  (:require [sicp-mailonline.exercises.2-2 :refer :all]))

(defprotocol Rectangle
  (height [this])
  (width [this])
  (bottom-left [this]))

;; perimeter & area will work with any abstraction implementing the Rectangle
;; protocol - thereby providing height & width

(defn perimeter [rectangle]
  (+ (* (height rectangle) 2)
     (* (width rectangle) 2)))

(defn area [rectangle]
  (* (width rectangle)
     (height rectangle)))

;; first implementation - using a line segment to represent the diagonal

(defrecord RectangleImpl1 [diagonal-segment]
  Rectangle
  (height [this]
    (- (y-point (end-segment diagonal-segment))
       (y-point (start-segment diagonal-segment))))
  
  (width [this]
    (- (x-point (end-segment diagonal-segment))
       (x-point (start-segment diagonal-segment))))

  (bottom-left [this]
    (start-segment diagonal-segment)))

(defn make-rectangle1 [bottom-left top-right]
  (RectangleImpl1. (make-segment bottom-left top-right)))

;; second implementation

(defrecord RectangleImpl2 [bottom-left height width]
  Rectangle
  (height [this]
    height)

  (width [this]
    width)

  (bottom-left [this]
    bottom-left))

(defn make-rectangle2 [bottom-left height width]
  (RectangleImpl2. bottom-left height width))
