;; Exercise 2.14
;; Demonstrate that Lem is right.  Investigate the behaviour of the system on a
;; variety of arithmetic expressions.  Make some intervals A and B, and use them
;; in computing the expressions A/A and A/B.  You will get the most insight by
;; using intervals whose width is a small percentage of the center value.
;; Examine the results of the computation in center-percent form
;; (see exercise 2.12).

;; This exercise follows the following description in the book:
;;
;; Lem has noticed that the formula for parallel resistors can be written in
;; two algebraically equivalent ways:
;;
;;   R1*R2 / (R1 + R2)
;;
;; and
;;
;;  1 / (1/R1 + 1/R2)
;;
;; Lem complains that Alyssa's program gives different answers for the two ways
;; of computing.

(ns sicp-mailonline.exercises.2-14
  (:require [sicp-mailonline.exercises.2-7 :refer :all]))

(defn par1 [r1 r2]
  (div-interval (mul-interval r1 r2)
                (add-interval r1 r2)))

(defn par2 [r1 r2]
  (let [one (make-interval 1 1)]
    (div-interval one
                  (add-interval (div-interval one r1)
                                (div-interval one r2)))))
