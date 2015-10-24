;; Exercise 3.25
;; Generalizing one- and two-dimensional tables, show how to implement a table
;; in which values are stored under an arbitrary number of keys and different
;; values may be stored under different numbers of keys.  The lookup and insert!
;; procedures should take as input a list of keys used to access the table.

(define (make-table)
  (let ((local-table (list '*table*)))
    (define (assoc keys records)
      (cond ((null? records) false)
            ((equal? keys (caar records)) (car records))
            (else (assoc keys (cdr records)))))
    (define (lookup keys)
      (let ((record (assoc keys (cdr local-table))))
        (if record
            (cdr record)
            false)))
    (define (insert! keys value)
      (let ((record (assoc keys (cdr local-table))))
        (if record
            (set-cdr! record value)
            (set-cdr! local-table
                      (cons (cons keys value) (cdr local-table)))))
      'ok)
    (define (dispatch m)
      (cond ((eq? m 'lookup-proc) lookup)
            ((eq? m 'insert-proc!) insert!)
            (else (error "Unknown operation -- TABLE" m))))

    dispatch))

;; test

(define t (make-table))

((t 'insert-proc!) '(1) 'one)
((t 'insert-proc!) '(1 fr) 'une)

((t 'lookup-proc) '(1))
;; -> one
((t 'lookup-proc) '(1 fr))
;; -> une

