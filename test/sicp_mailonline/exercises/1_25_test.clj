;; Exercise 1.25

(ns sicp-mailonline.exercises.1-25-test
  (:require [sicp-mailonline.exercises.1-25 :as exercise]
            [sicp-mailonline.examples.1-2-6 :as example]
            [clojure.test :refer :all]))

(def ^:private ^:const times 20)

(deftest exercise1-25
  (testing "Alyssa`s approach is prone to numeric overflow"
    (is (thrown-with-msg? ArithmeticException #"integer overflow"
                          (exercise/fast-prime? 19 times))))

  (testing "the Book`s approach"
    (is (example/fast-prime? 19 times))))

;; Alysssa's solution is prone to numeric overflow, because it attempts to
;; calculate the exponent before undertaking any division.  Even testing
;; whether a relatively small number such as 19 can result in an attempt
;; to calculate a value such as 10^19 - which overflows the range of an int.
;;
;; A simple illustration of the difference between Alyssa's and the books
;; approach can be demonstrated by expanding (expmod 10 4 2).
;;
;; Alyssa's approach:
;; (expmod 10 4 2)
;; (rem (fast-expt 10 4) 2)
;; (rem (square (fast-expt 10 2)) 2)
;; (rem (square (square (fast-expt 10 1))) 2)
;; (rem (square (square (* 10 (fast-expt 10 0)))) 2)
;; (rem (square (square (* 10 1))) 2)
;; (rem (square (square 10)) 2)
;; (rem (square 100) 2)
;; (rem 10000 2)
;; => 0
;; Note that 10^4 is first expanded into 10,000 before any division occurs.
;; It is easy to see that as exp increases, it does not take much for 10^exp
;; to overflow.
;;
;; The book's approach
;; (expmod 10 4 2)
;; (rem (square (expmod 10 2 2)) 2)
;; (rem (square (rem (square (expmod 10 1 2)) 2)) 2)
;; (rem (square (rem (square (rem (* 10 (expmod 10 0 2)) 2)) 2)) 2)
;; (rem (square (rem (square (rem (* 10 1) 2)) 2)) 2)
;; (rem (square (rem (square (rem 10 2)) 2)) 2)
;; (rem (square (rem (square 0) 2)) 2)
;; => 0
;; Note that the highest value calculated is (* 10 1), and so this algorithm
;; is not at risk of overflow as exp increases.
