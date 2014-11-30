;; Exercise 1.24
;; Modify the timed-prime-test procedure of exercise 1.22 to use fast-prime?
;; (the Fermat method), and test each of the 12 primes you found in that
;; exercise.  Since the Fermat test has O(log n) growth, how would you
;; expect the time to test primes near 1,000,000 to compare with the time
;; needed to test primes near 1,000?  Do your data bear this out?  Can you
;; explain any discrepancy you find?

(ns sicp-mailonline.exercises.1-24
  (:require [sicp-mailonline.examples.1-2-6 :refer [fast-prime?]]))

(def ^:private ^:const fermat-times 5)

;; exercise 1.22 implementation invoking fast-prime? rather than prime?
(defn- runtime []
  (System/nanoTime))

(defn- report-prime [elapsed-time]
  (printf " *** %d ns%n" elapsed-time))

(defn- start-prime-test [n start-time]
  (if (fast-prime? n fermat-times)
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
