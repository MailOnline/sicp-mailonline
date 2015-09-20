;; Exercise 3.18
;; Write a procedure that examines a list and determines whether it contains a
;; cycle, that is, whether a program that tried to find the end of the list by
;; taking successive cdrs would go into an infinite loop.  Exercise 3.13
;; constructed such lists.

;; Note that the make-cycle procedure of exercise 3.13 always points the end of
;; the list to the start of the list.  With such 'complete cycles', we can
;; simply test whether any pair in (cdr x) is x.  I assume that we are also
;; expected do identify 'partial cycles', where the end of the list points to
;; somewhere after the beginning.

(define (contains-cycle? x)
  (define (contains? p col)
    (cond ((null? col) false)
          ((eq? p (car col)) true)
          (else (contains? p (cdr col)))))
  (define (cyclic? c acc)
    (cond ((not (pair? c)) false)
          ((contains? c acc) true)
          (else (cyclic? (cdr c) (cons c acc)))))
  (cyclic? x '()))

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
