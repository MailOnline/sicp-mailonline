;; Exercise 2.6
;; In case representing pairs as procedures wasn't mind-boggling enough, consider
;; that, in a language that can manipulate procedures, we can get by without
;; numbers (at least insofar as nonnegative integers are concerned) by
;; implementing 0 and the operation of adding 1 as
;;
;; (define zero (lambda (f) (lambda (x) x)))
;;
;; (define (add-1 n)
;;   (lambda (f) (lambda (x) (f ((n f) x)))))
;;
;; This representation is known as Church numerals, after its inventor, Alonzo
;; Church, the logician who invented the lambda calculus.
;; Define one and two directly (not in terms of zero and add-1).
;; (Hint: Use substitution to evaluate (add-1 zero)).
;; Give a direct definition of the addition procedure + (not in terms of repeated
;; application of add-1).

(ns sicp-mailonline.exercises.2-6)

(defn zero [f]
  (fn [x] x))

(defn add-1 [n]
  (fn [f] (fn [x] (f ((n f) x)))))

;; (add-1 zero)
;; (fn [f] (fn [x] (f ((zero f) x))))
;; (fn [f] (fn [x] (f ((zero f) x))))
;; (fn [f] (fn [x] (f ((fn [x] x) x))))
;; => (fn [f] (fn [x] (f x)))

(defn one [f]
  (fn [x] (f x)))

;; (add-1 one)
;; (fn [f] (fn [x] (f ((one f) x))))
;; (fn [f] (fn [x] (f ((fn [x] (f x)) x))))
;; => (fn [f] (fn [x] (f (f x))))

(defn two [f]
  (fn [x] (f (f x))))

(defn add [a b]
  (fn [f] (fn [x] ((a f) ((b f) x)))))
