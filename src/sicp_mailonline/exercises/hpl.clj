  ;
; Clojure implementation of Henderson Picture Language
;

(ns sicp-mailonline.hpl
  (:require [clojure.java.io :as io]))

(import 
 '(java.awt Color Graphics Dimension)
 '(java.awt.image BufferedImage)
 '(java.io.File)
 '(javax.imageio.*)
 '(javax.swing JPanel JFrame))


;
; Implementation of vectors (as a pair consisting of an x and y co-ord)
;

(defn make-vect [x y]
  [x y])

(defn xcor-vect [vec]
  (get vec 0))

(defn ycor-vect [vec]
  (get vec 1))

(defn add-vect [a b]
  (make-vect 
    (+  (xcor-vect a) (xcor-vect b))
    (+  (ycor-vect a) (ycor-vect b))))

(defn sub-vect [a b]
  (make-vect 
    (-  (xcor-vect a) (xcor-vect b)
        (ycor-vect a) (ycor-vect b))))
        
(defn scale-vect [scalar vect]
  (make-vect 
    (* scalar (xcor-vect vect))
    (* scalar (ycor-vect vect))))


;
; Implementation of frames (as three vectors)
;

(defn make-frame [origin edge1 edge2]
  [origin edge1 edge2])

(defn origin-frame [frame]
  (get frame 0))

(defn edge1-frame [frame]
  (get frame 1))

(defn edge2-frame [frame]
  (get frame 2))


(defn frame-coord-map [frame]
  (fn [v]
    (add-vect 
      (origin-frame frame)
      (add-vect
        (scale-vect (xcor-vect v) (edge1-frame frame))
        (scale-vect (ycor-vect v) (edge2-frame frame))))))


; 
; Implementation of segments
;

(defn make-segment [start end]
  [start end])

(defn start-segment [segment]
  (get segment 0))

(defn end-segment [segment]
  (get segment 1))


;
; Graphics support
;

(defn draw-line [graphics point-a point-b]
  (. graphics drawLine 
    (xcor-vect point-a) (ycor-vect point-a)
    (xcor-vect point-b) (ycor-vect point-b)))


(defn render [g painter]
    (painter g
     (make-frame 
        (make-vect 10 10)
        (make-vect 390 10)
        (make-vect 10 390))))

(defn panel [painter] 
  (doto (proxy [JPanel] [] 
            (paint [g] (render g painter)))
        (.setPreferredSize (new Dimension 400 400))))

(defn show-picture [painter] 
  (doto (new JFrame) 
        (.add (panel painter)) .pack .show))


;
; Painters
;

(defn transform-painter [painter origin corner1 corner2]



  )



(defn segments-painter [segment-list]
  (fn [graphics frame]
    (doall (map
      (fn [segment]
        (draw-line graphics 
                   ((frame-coord-map frame) (start-segment segment))
                   ((frame-coord-map frame) (end-segment segment))))
      segment-list))))


(defn outline-painter [graphics frame]
  (let [s-p (segments-painter (list
              (make-segment (make-vect 0 0) (make-vect 0 1))
              (make-segment (make-vect 0 1) (make-vect 1 1))
              (make-segment (make-vect 1 1) (make-vect 1 0))
              (make-segment (make-vect 1 0) (make-vect 0 0))))]

    (s-p graphics frame)))


(defn make-rogers-painter [file]
  (let 
    [img (javax.imageio.ImageIO/read file)]

    (fn [graphics frame]
      (.drawImage 
        graphics
        img
        0 0 400 400 ; destination dx1 dy1 dx2 dy2   
        0 0 1000 1000 ; source
        nil))))


; 
; Read size of a buffered image
; Add a co-ordinate map
;
; Need to add methods that do image manipulation e.g. beside



; (defn wave)
;
; render and panel ge nested into show picture


(def rogers 
  (make-rogers-painter 
    (io/file (io/resource "barton.jpg"))))
  

;
; Move to markdown
; 

(show-picture rogers)










