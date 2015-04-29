;
; Clojure implementation of Henderson Picture Language
;

(ns sicp-mailonline.hpl
  (:require [clojure.java.io :as io])
  (:import (java.awt.geom AffineTransform)))

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
    (-  (xcor-vect a) (xcor-vect b))
    (-  (ycor-vect a) (ycor-vect b))))


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

; Returns a function that takes a vector in the unit square and maps
; it to co-ords in the provided frame
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

(def border 5.0)

(defn draw-line [graphics point-a point-b]
  (. graphics drawLine 
    (xcor-vect point-a) (ycor-vect point-a)
    (xcor-vect point-b) (ycor-vect point-b)))


(defn render [g painter width height]
    (painter g
     (make-frame 
        (make-vect border border)
        (make-vect (- width (* 2.0 border)) 0.0)
        (make-vect 0.0 (- height (* 2.0 border))))))

(defn panel [painter width height]
  (doto (proxy [JPanel] [] 
            (paint [g] (render g painter width height)))
        (.setPreferredSize (new Dimension width height))))

(defn show-picture [painter width height]
  (doto (new JFrame) 
        (.add (panel painter width height)) .pack .show))


;
; Painters
;

(def roger-barton-filename "barton.jpg")

; Creates a new painter from the old with the frame transformed
; Origin is the new origin, corner1 and corner 2 the corners on the x and y
; axis respectively of the frame into which the painer will write

(defn transform-painter [painter origin corner1 corner2]
  (fn frame [graphics frame]
    (let [m (frame-coord-map frame)]
      (let [new-origin (m origin)]
        (painter graphics (make-frame
                   new-origin
                   (sub-vect (m corner1) new-origin)
                   (sub-vect (m corner2) new-origin)))))))

(defn segments-painter [segment-list]
  (fn [graphics frame]
    (doall (map
      (fn [segment]
        (draw-line graphics 
                   ((frame-coord-map frame) (start-segment segment))
                   ((frame-coord-map frame) (end-segment segment))))
      segment-list))))

(defn beside [painter1 painter2]
  (let [split-point (make-vect 0.5 0.0)
        paint-left (transform-painter
                     painter1
                     (make-vect 0.0 0.0)
                     split-point
                     (make-vect 0.0 1.0))
        paint-right (transform-painter
                     painter2
                     split-point
                     (make-vect 1.0 0.0)
                     (make-vect 0.5 1.0))]
      (fn [graphics frame]
        (paint-left graphics frame)
        (paint-right graphics frame))))


(defn below [painter1 painter2]
  (let [split-point (make-vect 0.0 0.5)
        paint-bottom (transform-painter
                     painter1
                     split-point
                     (make-vect 1.0 0.5)
                     (make-vect 0.0 1.0))


        paint-top (transform-painter
                      painter2
                      (make-vect 0.0 0.0)
                      (make-vect 1.0 0.0)
                      split-point)]
    (fn [graphics frame]
      (paint-bottom graphics frame)
      (paint-top graphics frame))))


(defn flip-vert [painter]
  (transform-painter
    painter
      (make-vect 0.0 1.0)
      (make-vect 1.0 1.0)
      (make-vect 0.0 0.0)))

(defn rotate-90 [painter] ; rotates 90 anti-clockwise
  (transform-painter
    painter
     (make-vect 1.0 0.0)
     (make-vect 1.0 1.0)
     (make-vect 0.0 0.0)))

(defn make-image-painter [file]
  (let
    [img (javax.imageio.ImageIO/read file)]

    (fn [graphics frame]
      (let [
            source-width (.getWidth img)
            source-height (.getHeight img)

            ;
            ; Writing the unit square into the frame can be achieved by using an affine
            ; transform defined
            ;
            ; ( edge1.x   edge2.x   orig.x)
            ; ( edge1.y   edge2.x   orig.y)
            ; (   0         0         1   )
            ;
            ; However, the source image is a different size to the unit square so we have
            ; to shrink the x co-ord by its width and the y co-ord by its height before
            ; applying the above affine transform. This can be done using the following
            ; affine transform
            ;
            ; ( 1/width    0          0 )
            ; (   0       1/height    0 )
            ; (   0       0           1 )
            ;
            ; We can compose the transforms
            ;  [map on to frame] . [shrink]
            ; to give the final affine transform
            ;
            ; ( edge1.x/width   edge2.x/height   orig.x)
            ; ( edge1.y/width   edge2.x/height   orig.y)
            ; (       0               0            1   )
            ;

            affine-transform (new AffineTransform
                                  (/ (xcor-vect (edge1-frame frame)) source-width)
                                  (/ (ycor-vect (edge1-frame frame)) source-width)
                                  (/ (xcor-vect (edge2-frame frame)) source-height)
                                  (/ (ycor-vect (edge2-frame frame)) source-height)
                                  (xcor-vect (origin-frame frame))
                                  (ycor-vect (origin-frame frame)))]
        (.drawImage graphics img affine-transform nil)))))

(def rogers
  (make-image-painter
    (io/file (io/resource roger-barton-filename))))


(def wave (segments-painter
            (list
              (make-segment (make-vect 0.3 1.0) (make-vect 0.5 0.7))
              (make-segment (make-vect 0.7 1.0) (make-vect 0.5 0.7))
              (make-segment (make-vect 0.5 0.4) (make-vect 0.5 0.7))
              (make-segment (make-vect 0.5 0.0) (make-vect 0.3 0.2))
              (make-segment (make-vect 0.5 0.0) (make-vect 0.3 0.2))
              (make-segment (make-vect 0.5 0.0) (make-vect 0.7 0.2))
              (make-segment (make-vect 0.3 0.2) (make-vect 0.5 0.4))
              (make-segment (make-vect 0.7 0.2) (make-vect 0.5 0.4))
              (make-segment (make-vect 0.4 0.55) (make-vect 0.7 0.55))
              (make-segment (make-vect 0.4 0.55) (make-vect 0.3 0.4)))))

(def wave2 (beside wave (flip-vert wave)))

(def wave4 (below wave2 wave2))

(defn outline-painter [graphics frame]
  (let [s-p (segments-painter (list
                                (make-segment (make-vect 0 0) (make-vect 0 1))
                                (make-segment (make-vect 0 1) (make-vect 1 1))
                                (make-segment (make-vect 1 1) (make-vect 1 0))
                                (make-segment (make-vect 1 0) (make-vect 0 0))))]
    (s-p graphics frame)))



;
; Move to markdown
; 

;(show-picture (beside rogers (flip-vert rogers)) 400 400)

;(show-picture (rotate-90 rogers)  400 400)

;(show-picture rogers 400 400)

(show-picture wave4 400 400)
