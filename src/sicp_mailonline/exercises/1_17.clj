;; Exercise 1.17
;; The exponentiation algorithms in this section are based on performing
;; exponentiation by means ofrepeated multiplication.  In a similar way,
;; one can perform integer multiplication by means of repeated addition.
;; The following multiplication procedure (in which it is assumed that
;; our language can only add, not multiply) is analogous to the expt
;; procedure:
;;
;; (defn * [a b]
;;   (if (zero? b)
;;     0
;;     (+ a (* a (dec b)))))
;;
;; This algorithm takes a number of steps that is linear in b.  Now
;; suppose we include, together with addition, operations double, which
;; doubles an integer, and halve, which divides an (even) integer by 2.
;; Using these, design a multiplication procedure analogous to fast-expt
;; that uses a logarithmic number of steps.

(ns sicp-mailonline.exercises.1-17)

(defn- double [x]
  (+ x x))

(defn- halve [x]
  (/ x 2))

(defn fast-multiply [a b]
  (cond
   (zero? b) 0
   (= b 1) a
   (= b -1) (- a)
   (even? b) (double (fast-multiply a (halve b)))
   :else (+ a (fast-multiply a (dec b)))))
