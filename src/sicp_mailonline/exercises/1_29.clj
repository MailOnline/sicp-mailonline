;; Exercise 1.29
;; Simpson's Rule is a more accurate method of numerical integration than the
;; method illustrated above.  Using Simpson's Rule, the integral of a function
;; f between a and b is approximated as
;;   h/3 [y0 + 4*y1 + 2*y2 + 4*y3 + 2*y4 + ... + 2*yn-2 + 4*yn-1 + yn]
;; where h = (b - a)/n, for some even integer n, and yk = f(a + k*h).
;; (Increasing n increases the accuracy of the approximation.)
;; Define a procedure that takes as arguments f, a, b, and n and returns the
;; value of the integral, computed using Simpson's Rule.
;; Use your procedure to integrate cube between 0 and 1 (with n=100 and n=1000),
;; and compare the results to those of the integral procedure shown above.

(ns sicp-mailonline.exercises.1-29
  (:require [sicp-mailonline.examples.1-3-1 :refer [sum]]))

(defn integral [f a b n]
  (let [h (/ (- b a) n)
        yk (fn [k] (f (+ a (* k h))))
        term (fn [k] (cond (zero? k) (yk k)
                           (= k n) (yk k)
                           (odd? k) (* 4 (yk k))
                           :else (* 2 (yk k))))]
    (* (/ h 3)
       (sum term 0 inc n))))
