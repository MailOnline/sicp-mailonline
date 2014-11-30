;; Exercise 1.23

(ns sicp-mailonline.exercises.1-23-test
  (:require [sicp-mailonline.exercises.1-23 :refer :all]
            [clojure.test :refer :all]))

;; (deftest exercise1-23
;;   (println " *** begin JVM warmup ***")
;;   (search-for-primes 1 2000000)
;;   (println " *** end JVM warmup ***")
           
;;   (testing "primes around 1000"
;;     (search-for-primes 1000 1019))
;;   ;; 1,009  (3,541 ns)
;;   ;; 1,013  (3,472 ns)
;;   ;; 1,019  (3,448 ns)
  
;;   (testing "primes around 10,000"
;;     (search-for-primes 10000 10037))
;;   ;; 10,007  ( 9,781 ns)
;;   ;; 10,009  (13,048 ns)
;;   ;; 10,037  ( 9,789 ns)
  
;;   (testing "primes around 100,000"
;;     (search-for-primes 100000 100043))
;;   ;; 100,003  (30,339 ns)
;;   ;; 100,019  (30,442 ns)
;;   ;; 100,043  (30,326 ns)
  
;;   (testing "primes around 1,000,000"
;;     (search-for-primes 1000000 1000037)))
;;   ;; 1,000,003  (95,247 ns)
;;   ;; 1,000,033  (94,567 ns)
;;   ;; 1,000,037  (95,220 ns)


;;         n  avg ns (1.23)  avg ns (1.22)   ratio (1.22 / 1.23)  
;;     1,000          3,487          4,276       1.2
;;    10,000         10,872         13,257       1.2
;;   100,000         30,389         45,585       1.5
;; 1,000,000         95,011        135,677       1.4
;;
;; => expectation of twice as fast is not confirmed.
;;    At best a 1.5x speedup.
;;    Possibly accounted for by the additional if condition introduced by next
;;    which is evaluated every time a new test-divisor is determined.
