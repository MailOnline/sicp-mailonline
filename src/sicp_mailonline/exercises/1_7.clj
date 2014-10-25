;; Exercise 1.7
;; The good-enough? test used in computing square roots will not be
;; very effective for finding the square root of very small numbers.
;; Also, in real computers, arithmetic operations are almost always
;; performed with limited precision.  This makes our test inadequate
;; for very large numbers.  

(ns sicp-mailonline.exercises.1-7)

(defn- average [x y]
  (/ (+ x y) 2))

(defn- improve [guess x]
  (average guess (/ x guess)))

(defn- square [x]
  (* x x))

;; =======================================
;; example uses a fixed tolerance approach
;; =======================================
(defn- fixed-tolerance-good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn- fixed-tolerance-sqrt-iter [guess x]
  (if (fixed-tolerance-good-enough? guess x)
    guess
    (fixed-tolerance-sqrt-iter (improve guess x)
                               x)))

(defn fixed-tolerance-sqrt [x]
  (fixed-tolerance-sqrt-iter 1.0 x))


;; An alternative strategy for implementing good-enough? is to watch
;; how guess changes from one iteration to the next and to stop when
;; the change is a very small fraction of the guess.  Design a square
;; root procedure that uses this kind of test.  
;; ============================================
;; exercise adopts a stabilising delta approach
;; ============================================
(defn- stabilising-delta-good-enough? [previous-guess guess]
  (< (Math/abs (- guess previous-guess))
     (Math/abs (* previous-guess 0.00001))))

(defn- stabilising-delta-sqrt-iter [previous-guess guess x]
  (if (stabilising-delta-good-enough? previous-guess guess)
    guess
    (stabilising-delta-sqrt-iter guess 
                                 (improve guess x) 
                                 x)))

(defn stabilising-delta-sqrt [x]
  (if (zero? x)
    0
    (stabilising-delta-sqrt-iter 0 1.0 x)))
