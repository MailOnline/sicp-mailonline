;; Exercise 2.54
;; Two lists are said to be equal? if they contain equal elements arranged in
;; the same order.  For example,
;;
;; (equal? '(this is a list) '(this is a list))
;;
;; is true, but
;;
;; (equal? '(this is a list) '(this (is a) list))
;;
;; is false.  To be more precise, we can define equal? recursively in terms of
;; the basic eq? equality of symbols by saying that a and b are equal? if they
;; are both symbols and the symbols are eq?, or if they are both lists such
;; that (car a) is equal? to (car b) and (cdr a) is equal? to (cdr b).  Using
;; this idea, implement equal? as a procedure.

(ns sicp-mailonline.exercises.2-54)

;; Clojure's immutable data structures provide equality comparisons based on
;; values.  All of the complexity detailed in this exercise can be handled by
;; simply delegating to =.
(defn equal? [a b]
  (= a b))

;; By contrast, in Scheme we would need something like the following:
;; (define (equal? a b)
;;   (cond ((and (null? a) (null? b)) #t)
;;         ((or (null? a) (null? b)) #f)
;;         ((and (pair? a) (pair? b)) (and (equal? (car a) (car b))
;;                                         (equal? (cdr a) (cdr b))))
;;         ((or (pair? a) (pair? b)) #f)
;;         (else (eq? a b))))
