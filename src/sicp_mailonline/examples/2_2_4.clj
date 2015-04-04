;; Example 2.2.4 - A Picture Language

(ns sicp-mailonline.examples.2-2-4
  (:require
            [sicp-mailonline.exercises.2-46 :refer [make-vect add-vect sub-vect scale-vect xcor-vect ycor-vect]]
            [sicp-mailonline.exercises.2-47 :refer [make-frame origin-frame edge1-frame edge2-frame]]
            [sicp-mailonline.exercises.2-48 :refer [start-segment end-segment]]
            [sicp-mailonline.exercises.2-23 :refer [for-each-a]
                                            :rename {for-each-a for-each}]))

(declare beside)
(declare below)
(declare flip-vert)
(declare flip-horiz)
(declare draw-line)
(declare up-split)

(defn flipped-pairs [painter]
  (let [painter2 (beside painter (flip-vert painter))]
    (below painter2 painter2)))

(defn right-split [painter n]
  (if (zero? n)
    painter
    (let [smaller (right-split painter (dec n))]
      (beside painter (below smaller smaller)))))

(defn corner-split [painter n]
  (if (zero? n)
    painter
    (let [up (up-split painter (dec n))
          right (right-split painter (dec n))
          top-left (beside up up)
          bottom-right (below right right)
          corner (corner-split painter (dec n))]
      (beside (below painter top-left)
              (below bottom-right corner)))))

(defn square-limit [painter n]
  (let [quarter (corner-split painter n)
        half (beside (flip-horiz quarter) quarter)]
    (below (flip-vert half) half)))

(defn square-of-four [tl tr bl br]
  (fn [painter]
    (let [top (beside (tl painter)
                      (tr painter))
          bottom (beside (bl painter)
                         (br painter))]
      (below bottom top))))

(defn frame-coord-map [frame]
  (fn [v]
    (add-vect
     (origin-frame frame)
     (add-vect (scale-vect (xcor-vect v)
                           (edge1-frame frame))
               (scale-vect (ycor-vect v)
                           (edge2-frame frame))))))

(defn segments->painter [segment-list]
  (fn [frame]
    (for-each (fn [segment]
                (draw-line
                 ((frame-coord-map frame) (start-segment segment))
                 ((frame-coord-map frame) (end-segment segment))))
              segment-list)))

(defn transform-painter [painter origin corner1 corner2]
  (fn [frame]
    (let [m (frame-coord-map frame)
          new-origin (m origin)]
      (painter (make-frame new-origin
                           (sub-vect (m corner1) new-origin)
                           (sub-vect (m corner2) new-origin))))))

(defn flip-vert [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)    ;; new origin
                     (make-vect 1.0 1.0)    ;; new end of edge1
                     (make-vect 0.0 0.0)))  ;; new end of edge2

(defn shrink-to-upper-right [painter]
  (transform-painter painter
                     (make-vect 0.5 0.5)
                     (make-vect 1.0 0.5)
                     (make-vect 0.5 1.0)))

(defn rotate90 [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))
(defn squash-inwards [painter]
  (transform-painter painter
                     (make-vect 0.0 0.0)
                     (make-vect 0.65 0.35)
                     (make-vect 0.35 0.65)))

(defn beside [painter1 painter2]
  (let [split-point (make-vect 0.5 0.0)
        paint-left (transform-painter painter1
                                      (make-vect 0.0 0.0)
                                      split-point
                                      (make-vect 0.0 1.0))
        paint-right (transform-painter painter2
                                       (split-point)
                                       (make-vect 1.0 0.0)
                                       (make-vect 0.5 1.0))]
    (fn [frame]
      (paint-left frame)
      (paint-right frame))))
