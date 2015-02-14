;; Exercise 2.22
;; Louis Reasoner tries to rewrite the first square-list procedure of exercise
;; 2.21 so that it evolves an iterative process:
;;
;; (define (square-list items)
;;   (define (iter things answer)
;;     (if (null? things)
;;       answer
;;       (iter (cdr things)
;;             (cons (square (car things))
;;                   answer))))
;;   (iter items nil))
;;
;; Unfortunately, defining square-list this way produces the answer list in the
;; reverse order of the one desired.  Why?
;; Louis then tries to fix his bug by interchanging the arguments to cons:
;;
;; (define (square-list items)
;;   (define (iter things answer)
;;     (if (null? things)
;;       answer
;;       (iter (cdr things)
;;             (cons answer
;;                   (square (car things))))))
;;   (iter items nil))
;;
;; This doesn't work either.  Explain.

;; The first solution works through the input list in order.  As each square is
;; added to the output list, it becomes the new head of the list (by virtue of
;; the way cons efficiently adds to the head).  Processing the second input
;; value thereby pushes the first square to the end of the output list, and so
;; on.  The result is that the output list is in reverse order to the input list.
;; The output list is ultimately evaluated as:
;;   (cons 16 (cons 9 (cons 4 (cons 1 '()))))
;;   => (16 9 4 1)

;; The second solution results in a nested list structure being created, as
;; consing a list to a value results in a pair consisting of the original list
;; and the value, rather than a new list consisting of the addition of value to
;; the original list.
;; e.g. (cons 1 '()) => (1) but
;;      (cons '() 1) => (() 1)
;; The output list is therefore ultimately evaluated as:
;;   (cons (cons (cons (cons '() 1) 4) 9) 16)
;;   => ((((() 1) 4) 9) 16)
