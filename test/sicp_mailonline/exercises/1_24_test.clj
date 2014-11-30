;; Exercise 1.24

(ns sicp-mailonline.exercises.1-24-test
  (:require [sicp-mailonline.exercises.1-24 :refer :all]
            [clojure.test :refer :all]))

;; Times recorded using a value of 5 for times in the Fermat test

;; (deftest exercise1-24
;;   (println " *** begin JVM warmup ***")
;;   (search-for-primes 1 2000000)
;;   (println " *** end JVM warmup ***")
           
;;   (testing "primes around 1000"
;;     (search-for-primes 1000 1019))
;;   ;; 1,009  (14,742 ns)
;;   ;; 1,013  (15,527 ns)
;;   ;; 1,019  (15,758 ns)
  
;;   (testing "primes around 10,000"
;;     (search-for-primes 10000 10037))
;;   ;; 10,007  (19,269 ns)
;;   ;; 10,009  (24,322 ns)
;;   ;; 10,037  (19,217 ns)
  
;;   (testing "primes around 100,000"
;;     (search-for-primes 100000 100043))
;;   ;; 100,003  (22,278 ns)
;;   ;; 100,019  (22,556 ns)
;;   ;; 100,043  (22,668 ns)
  
;;   (testing "primes around 1,000,000"
;;     (search-for-primes 1000000 1000037)))
;;   ;; 1,000,003  (25,595 ns)
;;   ;; 1,000,033  (25,495 ns)
;;   ;; 1,000,037  (26,067 ns)


;;         n    avg ns    avg ns / avg ns for n=1,000 
;;     1,000    15,342
;;    10,000    20,936            1.4
;;   100,000    22,500            1.5
;; 1,000,000    25,719            1.7
;; => processing time increases much slower than the increase in n
;;    this demonstrates O(log n) time complexity
