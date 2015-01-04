;; Exercise 1.25
;; Alyssa P. Hacker complains that we went to a lot of extra work in writing
;; expmod.  After all, she says, since we already know how to compute
;; exponentials, we could have simply written
;;
;; (define (expmod base exp m)
;;   (remainder (fast-expt base exp) m))
;;
;; Is she correct?  Would this procedure serve as well for our fast prime tester?
;; Explain.

(ns sicp-mailonline.exercises.1-25
  (:require [sicp-mailonline.examples.1-2-4 :refer [fast-expt]]))

(defn- square [n]
  (* n n))

;; substituting Alyssa`s expmod implementation into Example 1.2.6: Testing for Primality
(defn expmod [base exp m]
  (rem (fast-expt base exp) m))

(defn- fermat-test [n]
  (letfn [(try-it [a] (= (expmod a n n) a))]
    (try-it (inc (rand-int (dec n))))))

(defn fast-prime? [n times]
  (cond (zero? times) true
        (fermat-test n) (recur n (dec times))
        :else false))
