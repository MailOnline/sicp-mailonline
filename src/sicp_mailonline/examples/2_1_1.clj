;; Example 2.1.1: Arithmetic Operations for Rational Numbers
;;
;; Note that the Scheme implementation of the book uses the cons cell to provide
;; a pair.  Clojure does not have a cons cell data structure, and so a Vector is
;; used here.
;; Note also that Clojure actually has inbuilt support for rational numbers.

(ns sicp-mailonline.examples.2-1-1)

(defn- gcd [a b]
  (if (zero? b)
    a
    (recur b (rem a b))))

(defn make-rat
  "Returns the rational number whose numerator is the integer n and whose denominator is the integer d."
  [n d]
  (let [g (gcd n d)]
    (vector (/ n g) (/ d g))))     ;; in Scheme -> (cons (/ n g) (/ d g))

(defn numer
  "Returns the numerator of the rational number x."
  [x]
  (first x))                       ;; in Scheme -> (car x)

(defn denom
  "Returns the denominator of the rational number x."
  [x]
  (second x))                      ;; in Scheme -> (cdr x)

(defn print-rat [x]
  (printf "%n%d/%d" (numer x) (denom x)))

(defn add-rat [x y]
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat (- (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (numer x) (numer y))
            (* (denom x) (denom y))))

(defn div-rat [x y]
  (make-rat (* (numer x) (denom y))
            (* (denom x) (numer y))))

(defn equal-rat? [x y]
  (= (* (numer x) (denom y))
     (* (numer y) (denom x))))
