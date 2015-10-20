;; Exercise 3.23
;; A deque ('double-ended queue') is a sequence in which items can be inserted
;; and deleted at either the front or the rear.  Operations on deques are the
;; constructor make-deque, the predicate empty-deque?, selectors front-deque and
;; rear-deque, and mutators front-insert-deque!, rear-insert-deque!,
;; front-delete-deque!, and rear-delete-deque!  Show how to represent deques
;; using pairs, and give implementations of the operations.  All operations
;; should be accomplished in O(1) steps.
;;
;; -----------------------------------------------------------------------------
;; The key to this exercise is supporting rear-delete-deque! in O(1) steps.  We
;; need to be able to find the new rear without traversing the sequence.  This
;; implies moving from the singly-linked list implementation used so far, to a
;; doubly-linked list.  Each node in the list now contains a pair in the car
;; position, where that pair consists of a pointer to the previous node (in the
;; car position) and the value (in the cdr position).

;; As per subscript 23 associated with this exercise, we do not return the deque
;; from the mutator methods to prevent the interpreter from attempting to print
;; the doubly-linked list (which by definition contains cycles).  Instead we
;; provide a print-deque procedure, which prints the contents of the deque
;; rather than its internal representation.

;; private API

(define (front-ptr deque)
  (car deque))

(define (set-front-ptr! deque node)
  (set-car! deque node))

(define (rear-ptr deque)
  (cdr deque))

(define (set-rear-ptr! deque node)
  (set-cdr! deque node))

(define (set-deque! deque node)
  (set-front-ptr! deque node)
  (set-rear-ptr! deque node))

(define (entry node)
  (car node))

(define (next-ptr node)
  (cdr node))

(define (set-next-ptr! node next)
  (set-cdr! node next))

(define (previous-ptr entry)
  (car entry))

(define (set-previous-ptr! entry previous)
  (set-car! entry previous))

(define (value entry)
  (cdr entry))

;; public API

(define (make-deque)
  (cons '() '()))

(define (empty-deque? deque)
  (null? (front-ptr deque)))

(define (front-deque deque)
  (if (empty-deque? deque)
      (error "FRONT called with an empty deque")
      (value (entry (front-ptr deque)))))
  
(define (rear-deque deque)
  (if (empty-deque? deque)
      (error "REAR called with an empty deque")
      (value (entry (rear-ptr deque)))))

(define (front-insert-deque! deque value)
  (let ((new-entry (cons '() value)))
    (let ((new-node (cons new-entry '())))
      (cond ((empty-deque? deque)
             (set-deque! deque new-node))
            (else
             (set-next-ptr! new-node (front-ptr deque))
             (set-previous-ptr! (entry (front-ptr deque)) new-node)
             (set-front-ptr! deque new-node))))))

(define (rear-insert-deque! deque value)
  (let ((new-entry (cons '() value)))
    (let ((new-node (cons new-entry '())))
      (cond ((empty-deque? deque)
             (set-deque! deque new-node))
            (else
             (set-previous-ptr! new-entry (rear-ptr deque))
             (set-next-ptr! (rear-ptr deque) new-node)
             (set-rear-ptr! deque new-node))))))

(define (front-delete-deque! deque)
  (cond ((empty-deque? deque)
         (error "FRONT-DELETE! called with an empty deque"))
        ((eq? (car deque) (cdr deque))
         (set-deque! deque '()))
        (else
         (set-previous-ptr! (entry (next-ptr (front-ptr deque))) '())
         (set-front-ptr! deque (next-ptr (front-ptr deque))))))

(define (rear-delete-deque! deque)
  (cond ((empty-deque? deque)
         (error "REAR-DELETE! called with an empty deque"))
        ((eq? (car deque) (cdr deque))
         (set-deque! deque '()))
        (else
         (set-rear-ptr! deque (previous-ptr (entry (rear-ptr deque))))
         (set-next-ptr! (rear-ptr deque) '()))))

(define (print-deque deque)
  (define (iter node acc)
    (if (null? node)
        acc
        (iter (previous-ptr (entry node))
              (cons (value (entry node)) acc))))
  (iter (rear-ptr deque) '()))

;; test 1
(define d (make-deque))
(print-deque d)
;; -> ()

(front-insert-deque! d 'a)
(rear-insert-deque! d 'b)
(front-insert-deque! d 'c)
(front-deque d)
;; -> c
(rear-deque d)
;; -> b
(print-deque d)
;; -> (c a b)

(rear-delete-deque! d)
(rear-deque d)
;; -> a
(front-delete-deque! d)
(front-deque d)
;; -> a
(rear-delete-deque! d)
(print-deque d)
;; -> ()

;; test2
(define d (make-deque))
(print-deque d)
;; -> ()

(rear-insert-deque! d 'a)
(rear-insert-deque! d 'b)
(front-insert-deque! d 'c)
(front-deque d)
;; -> c
(rear-deque d)
;; -> b
(print-deque d)
;; -> (c a b)

(rear-delete-deque! d)
(rear-deque d)
;; -> a
(front-delete-deque! d)
(front-deque d)
;; -> a
(front-delete-deque! d)
(print-deque d)
;; -> ()
