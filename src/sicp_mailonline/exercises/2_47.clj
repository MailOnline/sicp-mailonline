;; Exercise 2.47
;; Here are two possible constructors for frames:
;;
;; (define (make-frame origin edge1 edge2)
;;   (list origin edge1 edge2))
;;
;; (define (make-frame origin edge1 edge2)
;;   (cons origin (cons edge1 edge2)))
;;
;; For each constructor supply the appropriate selectors to produce an
;; implementation for frames.

(ns sicp-mailonlline.exercises.2-47)

(defn make-frame [origin edge1 edge2]
  (list origin edge1 edge2))

(defn origin-frame [frame]
  (first frame))

(defn edge1-frame [frame]
  (second frame))

(defn edge2-frame [frame]
  (nth frame 3))

;; The alternative constructor relies on the traditional Lisp cons-cell to
;; provide a 'pair', and is not supported by Clojure.  In Scheme, the
;; relevant selectors would be:
;;
;; (define (origin-frame frame)
;;   (car frame))
;;
;; (define (edge1-frame frame)
;;   (car (cdr frame)))
;;
;; (define (edge2-frame frame)
;;   (cdr (cdr frame)))
