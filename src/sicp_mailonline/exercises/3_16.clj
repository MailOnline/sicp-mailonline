;; Exercise 3.16
;; Ben Bitdiddle decides to write a procedure to count the number of pairs in
;; any list structure.  "It's easy", he reasons.  "The number of pairs in any
;; structure is the number in the car plus the number in the cdr plus one more
;; to count the current pair."  So Ben writes the following procedure:
;;
;; (define (count-pairs x)
;;   (if (not (pair? x))
;;     0
;;     (+ (count-pairs (car x))
;;        (count-pairs (cdr x))
;;        1)))
;;
;; Show that this procedure is not correct.  In particular, draw box-and-pointer
;; diagrams representing list structures made up of exactly three pairs for
;; which Ben's procedure would return 3; return 4; return 7; never return at
;; all.
;;
;; return 3
;; --------
;; (define x (list 1 2 3))
;; x -> (1 2 3)
;;
;; (count-pairs x)
;; -> 3
;;           3 /
;;          [*|*]
;;        2 |
;;       [*|*]
;;     1 |
;; x->[*|*]
;;
;; return 4
;; --------
;; (define x (list 1 2 3))
;; (set-car! (cdr x) (cddr x))
;; x -> (1 (3) 3)
;;
;; (count-pairs x)
;; -> 4
;;        
;;           3 /
;;        ->[*|*]
;;        | |
;;       [*|*]
;;     1 |
;; x->[*|*]
;;
;; return 7
;; --------
;; (define x (list 1 2 3))
;; (set-car! (cdr x) (cddr x))
;; (set-car! x (cdr x))
;; x -> (((3) 3) (3) 3)
;;
;; (count-pairs x)
;; -> 7
;;           3 /
;;        ->[*|*]
;;        | |
;;     ->[*|*]
;;     | |
;; x->[*|*]
;;
;; never return at all
;; -------------------
;; (define x (list 1 2 3))
;; (set-cdr! (cddr x) x)
;; x -> (1 2 3 ... 1 2 3 ...)
;;
;; (count-pairs x)
;; -> Aborting!: maximum recursion depth exceeded
;;
;;           3 
;;          [*|*]
;;        2 |  |
;;       [*|*] |
;;     1 |     |
;; x->[*|*]<---|
