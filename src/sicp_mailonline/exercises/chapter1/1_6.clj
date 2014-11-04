(ns sicp-mailonline.exercises.chapter1.1-6)

;; Alyssa P. Hacker doesn't see whey if needs to be provided as a special form. "Why can't
;; I just define it as an ordinary procedure in terms of cond?", she asks. Alyssa's friend
;; Eva Lu Ator claims this can indeed be done, and she defines a new version of if:

(defn new-if [predicate then-clause else-clause]
  (cond
   predicate then-clause
   :else else-clause))

Eva demonstrates the program for Alyssa:

(new-if (= 2 3) 0 5)
(new-if (= 1 1) 0 5)

Delighted, Alyssa uses new-if to rewrite the square-root program:

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x)
                     x)))

;; What happens when Alyssa attempts to use this to compute the square roots?

;; Answer:
;; You will get infinite recursion leading to a stack overflow.
;; This is because new-if is now an ordinary procedure that uses applicative-order evaluation
;; that evaluates all it's argument expressions before replacing the formal parameters in new-if
;; with the values of these sub-expressions (this is unlike the 'if' special-form which doesn't
;; evaluate all it's operand sub-expressions, only the one applicable to the predicate result).
;; Hence, the sqrt-iter sub-expression will be called recursively without any termination
;; condition leading ultimately to a stack overflow.
