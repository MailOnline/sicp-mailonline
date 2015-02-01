;; Exercise 2.16
;; Explain, in general, why equivalent algebraic expressions may lead to
;; different answers.  Can you devise an interval-arithmetic package that
;; does not have this shortcoming, or is this task impossible?
;; (Warning: This problem is very difficult.)

;; see https://en.wikipedia.org/wiki/interval_arithmetic
;; "The so-called dependency problem is a major obstacle to the application of
;; interval arithmetic.  Although interval methods can determine the range of
;; elementary arithmetic operations and functions very accurately, this is not
;; always true with more complicated functions.  If an interval occurs several
;; times in a calculation using parameters, and each occurrence is taken
;; independently then this can lead to an unwanted expansion of the resulting
;; intervals".

;; not every function can be re-written in such a way as to ensure that each
;; interval is represented only once.
