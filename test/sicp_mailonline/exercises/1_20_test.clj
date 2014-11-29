;; Exercise 1.20
;; The process that a procedure generates is of course dependent on the rules
;; used by the interpreter.  As an example, consider the iterative gcd
;; procedure given above.  Suppose we were to interpret this procedure
;; using normal-order evaluation, as discussed in section 1.1.5.  (The
;; normal-order-evaluation rule for if is described in exercise 1.5.)
;; Using the substitution method (for normal order), illustrate the
;; process generated in evaluating (gcd 206 40) and indicate the remainder
;; operations that are actually performed.  How many remainder operations
;; are actually performed in the normal-order evaluation of (gcd 206 40)?

(ns sicp-mailonline.exercises.1-20-test
  (:require [clojure.test :refer :all]))

(defn- gcd [a b]
  (if (zero? b)
    a
    (gcd b (rem a b))))

;; (gcd 206 40)                                            ;  0
;;
;; (gcd 40
;;      (rem 206 40))                                      ;  0
;;
;; (gcd (rem 206 40)
;;      (rem 40
;;           (rem 206 40)))                                ;  1
;;
;; (gcd (rem 40 (rem 206 40))
;;      (rem (rem 206 40)
;;           (rem 40 (rem 206 40))))                       ;  3 
;;
;; (gcd (rem (rem 206 40) (rem 40 (rem 206 40)))
;;      (rem (rem 40 (rem 206 40))
;;           (rem (rem 206 40) (rem 40 (rem 206 40)))))    ;  7
;;
;; (rem (rem 206 40) (rem 40 (rem 206 40)))                ; 14
;; => 2                                                    ; 18
;;
;; 18 rem operations are performed with normal-order evaluation


;; In the applicative-order evaluation?

;; (gcd 206 40)             ; 0
;; (gcd 40 (rem 206 40))    ; 0
;; (gcd 40 6)               ; 1
;; (gcd 6 (rem 40 6))       ; 1
;; (gcd 6 4)                ; 2
;; (gcd 4 (rem 6 4))        ; 2
;; (gcd 4 2)                ; 3
;; (gcd 2 (rem 4 2))        ; 3
;; (gcd 2 0)                ; 4
;; => 2                     ; 4

;; 4 rem operations are performed with applivative-order evaluation

(deftest exercise1-20
  (testing "GCD"
    (is (= 2
           (gcd 206 40)))))
