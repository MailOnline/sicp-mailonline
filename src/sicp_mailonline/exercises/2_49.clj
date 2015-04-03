;; Exercise 2.49
;; Use segments->painter to define the following primitive painters:
;; a.  The painter that draws the outline of the designated frame.
;; b.  The painter that draws an 'X' by connecting opposite corners of the frame.
;; c.  The painter that draws a diamond shape by connecting the midpoints of the
;;     sides of the frame.
;; d.  The wave painter.

(ns sicp-mailonline.exercises.2-49
  (:require [sicp-mailonline.examples.2-2-4 :refer [segments->painter]]
            [sicp-mailonline.exercises.2-48 :refer [make-segment]]))

;;           *                vertex (1,1)
;;
;;   *                        edge2
;;                   *        edge1
;;
;;          *                 origin (0,0)

;; a
(defn outline-painter []
  (let [origin->edge2 (make-segment 0 0 0 1)
        edge2->vertex (make-segment 0 1 1 1)
        vertex->edge1 (make-segment 1 1 1 0)
        edge1->origin (make-segment 1 0 0 0)]
    (segments->painter (list origin->edge2
                             edge2->vertex
                             vertex->edge1
                             edge1->origin))))

;; b
(defn x-painter []
  (let [edge2->edge1 (make-segment 0 1 1 0)
        origin->vertex (make-segment 0 0 1 1)]
    (segments->painter (list edge2->edge1
                             origin->vertex))))

;; c
(defn diamond-painter []
  (let [origin-edge2->edge2-vertex (make-segment 0 0.5 0.5 1)
        edge2-vertex->vertex-edge1 (make-segment 0.5 1 1 0.5)
        vertex-edge1->edge1-origin (make-segment 1 0.5 0.5 0)
        edge1-origin->origin-edge2 (make-segment 0.5 0 0 0.5)]
    (segments->painter (list origin-edge2->edge2-vertex
                             edge2-vertex->vertex-edge1
                             vertex-edge1->edge1-origin
                             edge1-origin->origin-edge2))))

;; d
;; Segments obtained by measuring figure 2.10 (page 129) with a ruler!
;; All measurements in mm (max x=49.5; max y=49.5)
;;
;; left-hand side
;; (12,0) -> (17,24.5)
;; (17,24.5) -> (15,29.5)
;; (15,29.5) -> (7.5,20)
;; (7.5,20) -> (0,32)
;; (0,42)-> (7.5,29.5)
;; (7.5,29.5) -> (10,32)
;; (10,32) -> (20,32)
;; (20,32) -> (17.5,42)
;; (17.5,42) -> (19.5,49.5)
;;
;; right-hand side
;; (29.5,49.5) -> (32,42)
;; (32,42) -> (29.5,32)
;; (29.5,32) -> (37,32)
;; (37,32) -> (49.5,17.5)
;; (49.5,7.5) -> (29.5,22)
;; (29.5,22) -> (37,0)
;;
;; bottom
;; (29.5,0) -> (24.5,15)
;; (24.5,15) -> (19.5,0)
(defn wave-painter []
  (let [segments (list (make-segment 0.242 0.000 0.343 0.495)
                       (make_segment 0.343 0.495 0.303 0.596)
                       (make_segment 0.303 0.596 0.152 0.404)
                       (make_segment 0.152 0.404 0.000 0.646)
                       (make_segment 0.000 0.848 0.152 0.596)
                       (make_segment 0.152 0.596 0.202 0.646)
                       (make_segment 0.202 0.646 0.404 0.646)
                       (make_segment 0.404 0.646 0.354 0.848)
                       (make_segment 0.354 0.848 0.394 1.000)
                       (make_segment 0.596 1.000 0.646 0.848)
                       (make_segment 0.646 0.848 0.596 0.646)
                       (make_segment 0.596 0.646 0.747 0.646)
                       (make_segment 0.747 0.646 1.000 0.354)
                       (make_segment 1.000 0.152 0.596 0.444)
                       (make_segment 0.596 0.444 0.747 0.000)
                       (make_segment 0.596 0.000 0.495 0.303)
                       (make_segment 0.495 0.303 0.394 0.000)))]
  (segments->painter segments))
