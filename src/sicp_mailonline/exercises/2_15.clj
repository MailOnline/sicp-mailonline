;; Exercise 2.15
;; Eva Lu Ator, another user, has also noticed the different intervals computed
;; by different but algebraically equivalent expressions.  She says that a formula
;; to compute with intervals using Alyssa's system will produce tighter error
;; bounds if it can be written in such a form that no variable that represents an
;; uncertain number is repeated.  Thus, she says par2 is a "better" program for
;; parallel resistance than par1.  Is she right?  Why?

;; Yes - she is correct that par2 produces a result with tighter error bounds.
;; This is illustrated in the test output for exercise 2.14, where both par1
;; and par2 produce an interval with the same center, but the percent value is
;; much higher for par1 than par2.
;;
;; The two formulas for calculating parallel resistance are algebraically
;; equivalent.  This equivalence is based on the mathematical property that
;; x/x = 1 for any x.  However, this property does not hold for intervals.
;; In particular, the test output for exercise 2.14 demonstrates that while
;; A/A has a center of 1, the percent value is much higher than that of A.
