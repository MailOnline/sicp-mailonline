;; Exercise 3.37
;; The celsius-fahrenheit-converter procedure is cumbersome when compared with a
;; more expression-oriented style of definition, such as
;;
;; (define (celsius-fahrenheit-converter x)
;;   (c+ (c* (c/ (cv 9) (cv 5))
;;           x)
;;       (cv 32)))
;;
;; (define C (make-connector))
;; (define F (celsius-fahrenheit-converter C))
;;
;; Here c+, c*, etc. are the "constraint" versions of the arithmetic
;; operations.  For example, c+ takes two connectors as arguments and returns a
;; connector that is related to these by an adder constraint:
;;
;; (define (c+ x y)
;;   (let ((z (make-connector)))
;;     (adder x y z)
;;     z))
;;
;; Define analogous procedures c-,c*,c/, and cv (constant value) that enable us
;; to define compound constraints as in the converter example above.

(ns sicp-mailonline.exercises.3-37
  (:require [sicp-mailonline.examples.3-3-5.constraints :as con]))

(defn c+ [x y]
  (let [z (con/make-connector)]
    (con/adder x y z)
    z))

;; x - y = z  ->  x = z + y
(defn c- [x y]
  (let [z (con/make-connector)]
    (con/adder z y x)
    z))

(defn c* [x y]
  (let [z (con/make-connector)]
    (con/multiplier x y z)
    z))

;; cannot use c/ as '/' is special in Clojure (denoting a ns separator)
;; x / y = z  ->  x = z * y
(defn c-div [x y]
  (let [z (con/make-connector)]
    (con/multiplier z y x)
    z))

(defn cv [x]
  (let [z (con/make-connector)]
    (con/constant x z)
    z))

(defn celsius-fahrenheit-converter [x]
  (c+ (c* (c-div (cv 9) (cv 5))
          x)
      (cv 32)))
