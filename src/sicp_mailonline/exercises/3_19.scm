;; Exercise 3.19
;; Redo exercise 3.18 using an algorithm that takes only a constant amount of
;; space.  (This requires a very clever idea).

;; The clever idea here is Floyd's cycle finding algorithm,
;; see: https://en.wikipedia.org/wiki/Cycle_detection.
;; We maintain two pointers as we iterate the list, with one moving twice as
;; fast as the other.  If the pointers ever meet, there is a cycle.
(define (contains-cycle? x)
  (define (advance-one c)
    (if (pair? c)
        (cdr c)
        '()))
  (define (advance-two c)
    (advance-one (advance-one c)))
  (define (cyclic? a b)
    (cond ((not (pair? a)) false)
          ((eq? a b) true)
          (else (cyclic? (advance-one a) (advance-two b)))))
  (if (pair? x)
      (cyclic? (advance-one x) (advance-two x))
      false))

;; exercise 3.12 provides
(define (last-pair x)
  (if (null? (cdr x))
      x
      (last-pair (cdr x))))

;; exercise 3.13 provides
(define (make-cycle x)
  (set-cdr! (last-pair x) x)
  x)

;; tests
(contains-cycle? '())
;; -> false

(contains-cycle? (list 1))
;; -> false

(contains-cycle? (list 1 2 3))
;; -> false

(contains-cycle? (list 1 2 3 1 2 3))
;; -> false

;; a complete cycle (end points to beginning)
(contains-cycle? (make-cycle (list 1 2 3)))
;; -> true

;; a partial cycle (end points to somewhere after the beginning)
(define x (list 1 2 3))
(set-cdr! (last-pair x) (cdr x))

;; x
;; -> (1 2 3 2 3 ... 2 3 ...)

(contains-cycle? x)
;; -> true
