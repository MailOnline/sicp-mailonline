;; Exercise 1.22
;; Most Lisp implementations include a primitive called runtime that returns an
;; integer that specifies the amount of time the system has been running
;; (measured, for example, in microseconds).  The following timed-prime-test
;; procedure, when called with an integer n, prints n and checks to see if n
;; is prime.  If n is prime, the procedure prints three asterisks followed by
;; the amount of time used in performing the test.
;; Using this procedure, write a procedure search-for-primes that checks the
;; primality of consecutive odd integers in a specified range.  Use your
;; procedure to find the three smallest primes larger than 1,000; larger than
;; 10,000; larger than 100,000; larger than 1,000,000.  Note the time needed to
;; test each prime.
;; Since the testing algorithm has order of growth O(sqrt(n)), you should expect
;; that testing for primes around 10,000 should take about sqrt(10) times as
;; long as testing for primes around 1,000.  Do your timing data bear this out?
;; How well do the data for 100,000 and 1,000,000 support the sqrt(n) prediction?
;; Is your result compatible with the notion that programs on your machine run
;; in time proportional to the number of steps required for the computation?

(ns sicp-mailonline.exercises.1-22
  (:require [sicp-mailonline.examples.1-2-6 :refer [prime?]]))

(defn- runtime []
  (System/nanoTime))

(defn- report-prime [elapsed-time]
  (printf " *** %d ns%n" elapsed-time))

(defn- start-prime-test [n start-time]
  (if (prime? n)
    (report-prime (- (runtime) start-time))))

(defn- timed-prime-test [n]
  (printf "%n%d" n)
  (start-prime-test n (runtime)))

(defn- iter [n end-value]
  (when (<= n end-value)
    (timed-prime-test n)
    (recur (+ n 2) end-value)))

(defn search-for-primes [start-value end-value]
  (if (even? start-value)
    (iter (inc start-value) end-value)
    (iter start-value end-value)))
