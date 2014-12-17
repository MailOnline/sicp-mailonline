;; Exercise 1.33
;; You can obtain an even more general version of accumulate (exercise 1.32) by
;; introducing the notion of a filter on the terms to be combined.  That is,
;; combine only those terms derived from values in the range that satisfy a
;; specified condition.  The resulting filtered-accumulate abstraction takes
;; the same arguments as accumulate, together with an additional predicate of
;; one argument that specifies the filter.  Write filtered-accumulate as a
;; procedure.  Show how to express the following using filtered-accumulate:
;;
;; a.  the sum of the squares of the prime numbers in the interval a to b
;;     (assuming that you have a prime? predicate already written)
;; b.  the product of all the positive integers less than n that are
;;     relatively prime to n (i.e. all positive integers i < n such that
;;     GCD(i,n) = 1).

(ns sicp-mailonline.exercises.1-33
  (:require [sicp-mailonline.examples.1-2-6 :refer [fast-prime?]]))

(defn filtered-accumulate [combiner null-value term next filter? a b]
  (cond (> a b) null-value
        (filter? a) (combiner (term a)
                              (filtered-accumulate combiner null-value term next filter? (next a) b))
        :else (filtered-accumulate combiner null-value term next filter? (next a) b)))

(defn sum-squares-primes [a b]
  (letfn [(square [x] (* x x))
          (prime? [x] (fast-prime? x 5))]
    (filtered-accumulate + 0 square inc prime? a b)))

(defn product-relatively-primes [n]
  (letfn [(gcd [a b] (if (zero? b) a (recur b (rem a b))))
          (relatively-prime? [i] (= 1 (gcd i n)))]    
    (filtered-accumulate * 1 identity inc relatively-prime? 2 (dec n))))
