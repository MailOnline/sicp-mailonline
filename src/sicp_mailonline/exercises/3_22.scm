;; Exercise 3.22
;; Instead of representing a queue as a pair of pointers, we can build a queue
;; as a procedure with local state.  The local state will consist of pointers to
;; the beginning and the end of an ordinary list.  Thus, the make-queue
;; procedure will have the form
;;
;; (define (make-queue)
;;   (let ((front-ptr ...)
;;         (rear-ptr ...))
;;     <definitions of internal procedures>
;;     (define (dispatch m) ...)
;;     dispatch))
;;
;; Complete the definition of make-queue and provide implementations of the
;; queue operations using this representation.

(define (make-queue)
  (let ((front-ptr '())
        (rear-ptr '()))
    (define (empty?)
      (null? front-ptr))
    (define (front)
      (if (empty?)
          (error "FRONT called with an empty queue")
          (car front-ptr)))      
    (define (insert! e)
      (let ((new-pair (cons e '())))
        (cond ((empty?)
                (set! front-ptr new-pair)
                (set! rear-ptr new-pair))
              (else
                (set-cdr! rear-ptr new-pair)
                (set! rear-ptr new-pair))))
      front-ptr)
    (define (delete!)
      (cond ((empty?) (error "DELETE! called with an empty queue"))
            (else
              (set! front-ptr (cdr front-ptr))
              front-ptr)))
    (define (dispatch m)
      (cond ((eq? m 'empty-queue?) (empty?))
            ((eq? m 'front-queue) (front))
            ((eq? m 'print-queue) front-ptr)
            ((eq? m 'insert-queue!) insert!)
            ((eq? m 'delete-queue!) (delete!))
            (else (error "Undefined operation -- MAKE-QUEUE" m))))
    dispatch))


;; tests
;; (define q (make-queue))
;; (q 'empty-queue?)
;; -> true
;; (q 'print-queue)
;; -> ()
;;
;; ((q 'insert-queue!) 'a)
;; (q 'empty-queue?)
;; -> false
;; (q 'print-queue)
;; -> (a)
;; (q 'front-queue)
;; -> a
;;
;; ((q 'insert-queue!) 'b)
;; (q 'empty-queue?)
;; -> false
;; (q 'print-queue)
;; -> (a b)
;; (q 'front-queue)
;; -> a
;; 
;; (q 'delete-queue!)
;; (q 'empty-queue?)
;; -> false
;; (q 'print-queue)
;; -> (b)
;; (q 'front-queue)
;; -> b
;;
;; (q 'delete-queue!)
;; (q 'empty-queue?)
;; -> true
;; (q 'print-queue)
;; -> ()
