;; Exercise 2.52
;; Make changes to the square limit of wave shown in figure 2.9 by working at
;; each of the levels described above.  In particular:
;; a.  Add some segments to the primitive wave painter of exercise 2.49 (to add
;;     a smile, for example).
;; b.  Change the pattern constructed by corner-split (for example, by using
;;     only one copy of the up-split and right-split images instead of two).
;; c.  Modify the version of square-limit that uses square-of-four so as to
;;     assemble the corners in a different pattern.  (For example, you might
;;     make the big Mr. Rogers look outward from each corner of the square.)

(ns sicp-mailonline.exercises.2-52
  (:require [sicp-mailonline.examples.2-2-4 :refer [segments->painter up-split right-split beside below square-of-four flip-horiz flip-vert]]
            [sicp-mailonline.exercises.2-48 :refer [make-segment]]
            [sicp-mailonline.exercises.2-50 :refer [rotate180]]))

;; a
(defn wave-painter []
  (let [segments (list (make-segment 0.242 0.000 0.343 0.495)
                       (make-segment 0.343 0.495 0.303 0.596)
                       (make-segment 0.303 0.596 0.152 0.404)
                       (make-segment 0.152 0.404 0.000 0.646)
                       (make-segment 0.000 0.848 0.152 0.596)
                       (make-segment 0.152 0.596 0.202 0.646)
                       (make-segment 0.202 0.646 0.404 0.646)
                       (make-segment 0.404 0.646 0.354 0.848)
                       (make-segment 0.354 0.848 0.394 1.000)
                       (make-segment 0.596 1.000 0.646 0.848)
                       (make-segment 0.646 0.848 0.596 0.646)
                       (make-segment 0.596 0.646 0.747 0.646)
                       (make-segment 0.747 0.646 1.000 0.354)
                       (make-segment 1.000 0.152 0.596 0.444)
                       (make-segment 0.596 0.444 0.747 0.000)
                       (make-segment 0.596 0.000 0.495 0.303)
                       (make-segment 0.495 0.303 0.394 0.000)
                       (make-segment 0.465 0.768 0.545 0.768))]   ;; smile
    (segments->painter segments)))

;; b
(defn corner-split [painter n]
  (if (zero? n)
    painter
    (let [up (up-split painter (dec n))
          right (right-split painter (dec n))
          corner (corner-split painter (dec n))]
      (beside (below painter up)
              (below right corner)))))

;; c
(defn square-limit [painter n]
  (let [combine4 (square-of-four identity
                                 flip-horiz
                                 flip-vert
                                 rotate180)]
    (combine4 (corner-split painter n))))
