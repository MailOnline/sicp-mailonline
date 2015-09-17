;; Exercise 3.17
;; Devise a correct version of the count-pairs procedure of exercise 3.16 that
;; returns the number of distinct pairs in any structure.  (Hint"" Traverse the
;; structure, maintaining an auxiliary data structure that is used to keep track
;; of which pairs have already been counted.)

(define (count-pairs x)
  (define (contains? e c)
    (cond ((null? c) false)
          ((eq? e (car c)) true)
          (else (contains? e (cdr c)))))
  (define (distinct-pairs x acc)
    (cond ((not (pair? x)) acc)
          ((contains? x acc) acc)
          (else (distinct-pairs (cdr x)
                                (distinct-pairs (car x) (cons x acc))))))
  (define (count x)
    (if (null? x)
      0
      (+ 1 (count (cdr x)))))
  
  (count (distinct-pairs x '())))


;; Ben Bitdiddle's algorithm returns 3
;; -----------------------------------
;; (define x (list 1 2 3))
;; x -> (1 2 3)
;;
;; (count-pairs x)
;; -> 3
;;
;; Ben Bitdiddle's algorithm returns 4
;; -----------------------------------
;; (define x (list 1 2 3))
;; (set-car! (cdr x) (cddr x))
;; x -> (1 (3) 3)
;;
;; (count-pairs x)
;; -> 3
;;
;; Ben Bitdiddle's algorithm returns 7
;; -----------------------------------
;; (define x (list 1 2 3))
;; (set-car! (cdr x) (cddr x))
;; (set-car! x (cdr x))
;; x -> (((3) 3) (3) 3)
;;
;; (count pairs x)
;; -> 3
;;
;; Ben Bitdiddle's algorithm never returned
;; ----------------------------------------
;; (define x (list 1 2 3))
;; (set-cdr! (cddr x) x)
;; x -> (1 2 3 ... 1 2 3 ...)
;;
;; (count-pairs x)
;; -> 3
