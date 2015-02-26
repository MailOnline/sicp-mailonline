; 
; Exercise 2.3
;
; Assume that rectangles sides are parallel to the 
; X and Y axis
;
; It is of course possible to provide more complex
; rectangle implementations that allow for all 
; orientations - but this would result in a large
; increase in complexity.
;
; It is clear that the focus of the exercise is use
; of abstraction to allow different represenations
; of rectangles  
;
;
(ns sicp-mailonline.core)

; Point abstraction
(defn make-point [x y]
  (list x y))

(defn x-point [point]
  (first point))

(defn y-point [point]
  (first (rest point)))

(defn print-point [p]
  (println "(" (x-point p) "," (y-point p) ")"))

; Rectangle abstraction - 1
; Consists of two points representing opposite
; corners
(defn mr1 [start end]
  (list start end))

(defn sr1 [rectangle]
  (first rectangle))

(defn er1 [rectangle]
  (first (rest rectangle)))

; Rectangle abstraction - 2
; Consists of lower left point + width
; and height

(defn mr2 [origin width height]
  (list origin width height))

(defn sr2 [rectangle]
  (first rectangle))

(defn er2 [rectangle]
  (make-point
    (+ (x-point (sr2 rectangle)) (first (rest rectangle)))
    (+ (y-point (sr2 rectangle)) (first (rest (rest rectangle))))))


; Rectangle functions
(defn abs [x]
  (if (< x 0)
    (- 0 x)
    x))

(defn diff [a b]
  (abs (- b a)))

(defn perimeter [start-rectangle end-rectangle rectangle]
  (* 2 
    (+
      (diff (y-point (end-rectangle rectangle))
            (y-point (start-rectangle rectangle)))

      (diff (x-point (end-rectangle rectangle))
            (x-point (start-rectangle rectangle))))))


(defn area [start-rectangle end-rectangle rectangle]
  (*
    (diff (y-point (end-rectangle rectangle))
            (y-point (start-rectangle rectangle)))
    (diff (x-point (end-rectangle rectangle))
            (x-point (start-rectangle rectangle)))))


