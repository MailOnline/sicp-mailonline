;; Exercise 1.27
;; Demonstrate that the Carmichael numbers listed in footnote 47 really do fool
;; the Fermat test.  That is, write a procedure that takes an integer n and
;; tests whether a^n is congruent to a modulo n for every a < n, and try your
;; procedure on the given Carmichael numbers.

(ns sicp-mailonline.exercises.1-27
  (:require [sicp-mailonline.examples.1-2-6 :refer [expmod]]))

(defn fermat-prime? [n]
  (letfn [(fermat? [a] (= (expmod a n n) a))
          (iter [a] (cond (zero? a) true      
                          (fermat? a) (recur (dec a))
                          :else false))]
    (iter (dec n))))

;; Example 1.2.6: Testing for Primality
;; Fermat's Little Theorem: if n is a prime number and a is any positive integer
;; less than n, then a raised to the nth power is congruent to a modulo n.
;; (Two numbers are said to be congruent modulo n if they both have the same
;; remainder when divided by n.)
