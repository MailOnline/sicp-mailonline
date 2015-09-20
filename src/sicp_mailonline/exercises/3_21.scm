;; Exercise 3.21
;; Ben Bitdiddle decides to test the queue implementation described above.  He
;; types in the procedures to the Lisp interpreter and proceeds to try them out:
;;
;; (define q1 (make-queue))
;;
;; (insert-queue! q1 'a)
;; -> ((a) a)
;;
;; (insert-queue! q1 'b)
;; -> ((a b) b)
;;
;; (delete-queue! q1)
;; -> ((b) b)
;;
;; (delete-queue! q1)
;; -> (() b)
;;
;; "It's all wrong!" he complains.  "The interpreter's response shows that the
;; last item is inserted into the queue twice.  And when I delete both items,
;; the second b is still there, so the queue isn't empty, even though it's
;; supposed to be."  Eva Lu Ator suggests that Ben has misunderstood what is
;; happening.  "It's not that the items are going into the queue twice", she
;; explains.  "It's just that the standard Lisp printer doesn't know how to make
;; sense of the queue representation.  If you want to see the queue printed
;; correctly, you'll have to define your own print procedure for queues."
;; Explain what Eva Lu Ator is talking about.  In particular, show why Ben's
;; examples produce the printed results they do.
;; Define a procedure print-queue that takes as input and prints the sequence of
;; items in the queue.

;; The queue reference is simply a pair of pointers to pairs.  The Lisp
;; interpreter follows pointers, and prints chains of pairs as a list
;; structure.  When an item is inserted into the queue, this will be accessible
;; via the pair chain from the front of the queue, and will be directly
;; referenced from the queue's rear-ptr.  Thus the printed representation of the
;; queue's two pointers will contain the rear value twice.  When items are
;; deleted from the queue, this implementation only adjusts the front of the
;; queue.  When the queue is emptied, the rear-ptr therefore continues to point
;; to what was the last value, which is why the printed representation appears
;; to suggest that the item has not been deleted.  As items are only accessed
;; via the front of the queue this is not a problem, as the front of the queue
;; reflects the fact that the queue is empty.
;;
;; (define q1 (make-queue))
;; (front-ptr q1) -> ()
;; (rear-ptr q1) -> ()
;; q1 -> (())
;; (print-queue q1) -> ()
;;
;; (insert-queue! q1 'a)
;; (front-ptr q1) -> (a)
;; (rear-ptr q1) -> (a)
;; q1 -> ((a) a)
;; (print-queue q1) -> (a)
;;
;; (insert-queue! q1 'b)
;; (front-ptr q1) -> (a b)
;; (rear-ptr q1) -> (b)
;; q1 -> ((a b) b)
;; (print-queue q1) -> (a b)
;;
;; (delete-queue! q1)
;; (front-ptr q1) -> (b)
;; (rear-ptr q1) -> (b)
;; q1 -> ((b) b)
;; (print-queue q1) -> (b)
;;
;; (delete-queue! q1)
;; (front-ptr q1) -> ()
;; (rear-ptr q1) -> (b)
;; q1 -> (() b)
;; (print-queue q1) -> ()

;; queue implementation of 3.3.2
(define (front-ptr queue)
  (car queue))

(define (rear-ptr queue)
  (cdr queue))

(define (set-front-ptr! queue item)
  (set-car! queue item))

(define (set-rear-ptr! queue item)
  (set-cdr! queue item))

(define (empty-queue? queue)
  (null? (front-ptr queue)))

(define (make-queue)
  (cons '() '()))

(define (front-queue queue)
  (if (empty-queue? queue)
      (error "FRONT called with an empty queue" queue)
      (car (front-ptr queue))))

(define (insert-queue! queue item)
  (let ((new-pair (cons item '())))
    (cond ((empty-queue? queue)
             (set-front-ptr! queue new-pair)
             (set-rear-ptr! queue new-pair)
             queue)
          (else
            (set-cdr! (rear-ptr queue) new-pair)
            (set-rear-ptr! queue new-pair)
            queue))))

(define (delete-queue! queue)
  (cond ((empty-queue? queue) (error "DELETE! called with an empty queue"
                                     queue))
        (else
         (set-front-ptr! queue (cdr (front-ptr queue)))
         queue)))

;; Define a procedure print-queue that takes as input and prints the sequence of
;; items in the queue.
(define (print-queue queue)
  (front-ptr queue))
