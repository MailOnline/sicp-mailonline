;; Exercise 1.46
;; Several of the numerical methods described in this chapter are instances of
;; an extremely general computational strategy known as iterative improvement.
;; Iterative improvement says that, to compute something, we start with an
;; initial guess for the answer, test if the guess is good enough, and otherwise
;; improve the guess and continue the process using the improved guess as the
;; new guess.
;; Write a procedure iterative-improve that takes two procedures as arguments:
;; a method for telling whether a guess is good enough and a method for
;; improving a guess.  Iterative-improve should return as its value a procedure
;; that takes a guess as argument and keeps improving the guess until it is good
;; enough.  Rewrite the sqrt procedure of section 1.1.7 and the fixed-point
;; procedure of section 1.3.3 in terms of iterative-improve.

(ns sicp-mailonline.exercises.1-46)

(defn iterative-improve [good-enough? improve]
  (fn [guess]
    (if (good-enough? guess)
      guess
      (recur (improve guess)))))

(defn- square [n]
  (* n n))

(defn- average [x y]
  (/ (+ x y) 2))

(defn- close-enough? [a b tolerance]
  (< (Math/abs (- a b)) tolerance))

(def ^:private ^:const initial-guess 1.0)

(defn sqrt [x]
  (letfn [(good-enough? [guess] (close-enough? (square guess) x 0.001))
          (improve [guess] (average guess (/ x guess)))]
    ((iterative-improve good-enough? improve) initial-guess)))

(defn fixed-point [f]
  (letfn [(good-enough? [guess] (close-enough? guess (f guess) 0.00001))]
    ((iterative-improve good-enough? f) initial-guess)))
