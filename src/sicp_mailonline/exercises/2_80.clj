;; Exercise 2.80
;; Define a generic predicate =zero? that tests if its argument is zero, and
;; install it in the generic arithmetic package.  This operation should work for
;; ordinary numbers, rational numbers, and complex numbers.

(ns sicp-mailonline.exercises.2-80)

(declare apply-generic put)
(declare numer)
(declare real-part imag-part)

;; generic arithmetic package
(defn =zero? [x]
  (apply-generic '=zero? x))

;; ordinary numbers
(defn install-scheme-number-package []
  (put '=zero? '(scheme-number) (fn [x] (= x 0))))

;; rational numbers
(defn install-rational-package []
  (put '=zero? '(rational) (fn [x] (= (numer x) 0))))

;; complex numbers
(defn install-complex-package []
  (put '=zero? '(complex) (fn [x] (and (= (real-part x) 0)
                                       (= (imag-part x) 0)))))
