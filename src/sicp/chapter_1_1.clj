;; # Building abstractions with procedures

(ns sicp.chapter_1_1
  (:require [clojure.test :refer :all]))

;; ## 1.1.7 Example: Square Roots by Newtons Method

;; An example is provided to calculate square roots by Newtons Method.

(defn square [x] (* x x))

;; An absolute value function, as an aside, I came across some weird
;; behaviour here, apparently:

(deftest test-equality
  (is (not (= 0 0.0))))

;; Using the java.lang.Math absolute function instead.

(defn abs [x]
  (Math/abs x))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.01))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x] (sqrt-iter 1.0 x))

;; ## Excercise 1.6

;; “ Alyssa P. Hacker doesn’t see why if needs to be provided as a
;; special form. “Why can’t I just define it as an ordinary procedure
;; in terms of cond?” she asks.”

;; “Alyssa’s friend Eva Lu Ator claims this can indeed be done, and
;; she defines a new version of if:

(defn new-if [predicate then-clause else-clause]
  "The if special form defined as a normal function" 
  (cond
   predicate then-clause
   :else else-clause))

;; The new version of if works for simple cases.

(deftest test-new-if
  (is (= (new-if (= 1 1) 0 5) 0)))


;; You can rewrite the square root program with 'new-if'

(defn new-sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (new-sqrt-iter (improve guess x) x)))

(defn new-sqrt [x] (new-sqrt-iter 1.0 x))


;; Sadly, when you try to run this, you will get a stack overflow exception:

(deftest test-new-sqrt
  (is (thrown? StackOverflowError (new-sqrt 9.0))))

;; The interpreter uses 'applicative order' evaluation so the
;; predicate, consequent and alternatives are all evaluated when the
;; 'new-if' function is called.
;;
;; Like so:
;; 
;;     sicp.chapter_1_1> (new-sqrt-iter 3.0 9.0)
;;     TRACE t14363: (sicp.chapter_1_1/new-sqrt-iter 3.0 9.0)
;;     TRACE t14364: | (sicp.chapter_1_1/good-enough? 3.0 9.0)
;;     TRACE t14364: | => true
;;     TRACE t14365: | (sicp.chapter_1_1/new-sqrt-iter 3.0 9.0)
;;     TRACE t14366: | | (sicp.chapter_1_1/good-enough? 3.0 9.0)
;;     TRACE t14366: | | => true


;; ## Excercise 1.7

;; The good enough procedure is not very good for small numbers:

(deftest test-good-enough-small-numbers
  (is (good-enough? 0.003 0.004))
  (is (good-enough? 0.0003 0.0004)))

;; This is because the tolerance is defined as absolute, to define a reclative tolerance.



