;; Exercise 2.79
;; Define a generic equality predicate equ? that tests the equality of two
;; numbers, and install it in the generic arithmetic package.  This operation
;; should work for ordinary numbers, rational numbers, and complex numbers.

(ns sicp-mailonline.exercises.2-79)

(declare apply-generic put)
(declare numer denom)
(declare real-part imag-part)

;; generic arithmetic procedure
(defn equ? [x y]
  (apply-generic 'equ? x y))

;; ordinary numbers
(defn install-scheme-number-package []
  (put 'equ? '(scheme-number scheme-number) (fn [x y] (= x y))))

;; rational numbers
(defn install-rational-package []
  (put 'equ? '(rational rational) (fn [x y] (and (= (numer x) (numer y))
                                                 (= (denom x) (denom y))))))

;; complex numbers
(defn install-complex-package []
  (put 'equ? '(complex complex) (fn [x y] (and (= (real-part x) (real-part y))
                                               (= (imag-part x) (imag-part y))))))
