;; Exercise 1.22

(ns sicp-mailonline.exercises.1-22-test
  (:require [sicp-mailonline.exercises.1-22 :refer :all]
            [clojure.test :refer :all]))

;; (deftest exercise1-22
;;   (println " *** begin JVM warmup ***")
;;   (search-for-primes 1 1000000)
;;   (println " *** end JVM warmup ***")
           
;;   (testing "primes around 1000"
;;     (search-for-primes 1000 1019))
;;   ;; 1,009  (4,327 ns)
;;   ;; 1,013  (4,265 ns)
;;   ;; 1,019  (4,238 ns)
  
;;   (testing "primes around 10,000"
;;     (search-for-primes 10000 10037))
;;   ;; 10,007  (13,338 ns)
;;   ;; 10,009  (13,270 ns)
;;   ;; 10,037  (13,165 ns)
  
;;   (testing "primes around 100,000"
;;     (search-for-primes 100000 100043))
;;   ;; 100,003  (52,299 ns)
;;   ;; 100,019  (42,145 ns)
;;   ;; 100,043  (42,312 ns)
  
;;   (testing "primes around 1,000,000"
;;     (search-for-primes 1000000 1000037)))
;;   ;; 1,000,003  (135,369 ns)
;;   ;; 1,000,033  (134,911 ns)
;;   ;; 1,000,037  (134,952 ns)


;;         n    avg ns    avg ns / avg ns for n=1,000 
;;     1,000     4,276
;;    10,000    13,257            3.1                  sqrt(10)   =  3.2
;;   100,000    45,585           10.7                  sqrt(100)  = 10.0
;; 1,000,000   135,677           31.7                  sqrt(1000) = 31.6
;;
;; => this timing data bears out the sqrt(n) prediction
;; => this result is compatible with the notion that programs on my machine
;;    run in time proportional to the number of steps required for the
;;    computation

;; NOTE that the JVM must be 'warmed' prior to timing operations in order
;; to obtain comparable results.
;; NOTE capturing nanoseconds rather than milliseconds as modern hardware
;; is significantly faster than that available when SICP was written.
