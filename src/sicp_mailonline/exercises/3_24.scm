;; Exercise 3.24
;; In the table implementations above, the keys are tested for equality using
;; equals? (called by assoc).  This is not always the appropriate test.  For
;; instance, we might have a table with numeric keys in which we don't need an
;; exact match to the number we're looking up, but only a number within some
;; tolerance of it.  Design a table constructor make-table that takes as an
;; argument a same-key? procedure that will be used to test "equality" of keys.
;; Make-table should return a dispatch procedure that can be used to access
;; appropriate lookup and insert! procedures for a local table.

(define (make-table same-key?)
  (let ((local-table (list '*table*)))
    (define (assoc key records)
      (cond ((null? records) false)
            ((same-key? key (caar records)) (car records))
            (else (assoc key (cdr records)))))
    (define (lookup key)
      (let ((record (assoc key (cdr local-table))))
        (if record
            (cdr record)
            false)))
    (define (insert! key value)
      (let ((record (assoc key (cdr local-table))))
        (if record
            (set-cdr! record value)
            (set-cdr! local-table
                      (cons (cons key value) (cdr local-table)))))
      'ok)
    (define (dispatch m)
      (cond ((eq? m 'lookup-proc) lookup)
            ((eq? m 'insert-proc!) insert!)
            (else (error "Unknown operation -- TABLE" m))))

    dispatch))

;; test

(define t (make-table (lambda (key-1 key-2) (eq? (ceiling->exact key-1)
                                                 (ceiling->exact key-2)))))
((t 'lookup-proc) 3.14)
;; -> false

((t 'insert-proc!) 3 'three)
;; -> ok

((t 'insert-proc!) 3.14 'pi)
;; -> ok

((t 'lookup-proc) 3)
;; -> three

((t 'lookup-proc) 3.14)
;; -> pi

((t 'insert-proc!) 4 'four)
;; -> ok

((t 'lookup-proc) 4)
;; -> four

((t 'lookup-proc) 3.14)
;; -> four
