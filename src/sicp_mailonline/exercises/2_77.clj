;; Exercise 2.77
;; Louis Reasoner tries to evaluate the expression (magnitude z) where z is the
;; object shown in figure 2.24.  To his surprise, instead of the answer 5 he
;; gets an error message from apply-generic, saying there is no method for the
;; operation magnitude on the types (complex).  He shows this interaction to
;; Alyssa P. Hacker, who says "The problem is that the complex-number selectors
;; were never defined for complex numbers, just for polar and rectangular
;; numbers.  All you have to do to make this work is add the following to the
;; complex package:"
;;
;; (put 'real-part '(complex) real-part)
;; (put 'imag-part '(complex) imag-part)
;; (put 'magnitude '(complex) magnitude)
;; (put 'angle '(complex) angle)
;;
;; Describe in detail why this works.  As an example, trace through all the
;; procedures called in evaluating the expression (magnitude z) where z is the
;; object shown in figure 2.24.  In particular, how many times is apply-generic
;; invoked?  What procedure is dispatched to in each case?

;; (def z (make-complex-from-real-imag 3 4))
;; -> (attach-tag 'complex (make-from-real-imag 3 4))
;; -> (attach-tag 'complex (attach-tag 'rectangular (cons 3 4)))
;; -> '(complex rectangular 3 . 4)
;; remember that we are dealing with Scheme cons cells here ...
;;
;; So, evaluate the procedure
;; (magnitude z)
;; -> (apply-generic 'magnitude z)
;;
;; This results in a procedure lookup:
;; (get 'magnitude '(complex))
;;
;; Which as a result of Alyssa's suggestion above, finds the magnitude procedure
;; in the complex package:
;;
;; (magnitude '(rectangular 3 . 4))
;; -> (apply-generic 'magnitude '(rectangular 3. 4))
;;
;; This results in a procedure lookup:
;; (get 'magnitude '(rectangular))
;;
;; Which returns the inner magnitude procedure from Ben's rectangular package.
;; When this is applied to the argument 3 . 4 it returns 5 as the result.

;; apply-generic is invoked twice.  If first dispatches to magnitude in the
;; complex package.  It then dispatches to magnitude in the rectangular package.
