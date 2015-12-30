;; Exercise 3.53
;; Without running the program, describe the elements of the stream defined by
;;
;; (define s (cons-stream 1 (add-stream s s)))

;; Defines a stream representing the powers of 2, where starting at 1, each
;; subsequent value is the sum of the current value with itself e.g.
;; 1, 2, 4, 8, 16, 32 ...
