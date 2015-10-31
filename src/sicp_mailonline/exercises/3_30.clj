;; Exercise 3.30
;; Figure 3.27 shows a ripple-carry adder formed by stringing together n
;; full-adders.  This is the simplest form of parallel adder for adding two
;; n-bit binary numbers.  The inputs A1,A2,A3,...,An and B1,B2,B3,...,Bn are the
;; two binary numbers to be added (each Ak and Bk is a 0 or 1).  The circuit
;; generates S1,S2,S3,...,Sn, the n bits of the sum, and C, the carry from the
;; addition.  Write a procedure ripple-carry-adder that generates this circuit.
;; The procedure should take as arguments three lists of n wires each - the Ak,
;; the Bk, and the Sk - and also another wire C.
;; The major drawback of the ripple-carry adder is the need to wait for the
;; carry signals to propagate.  What is the delay needed to obtain the complete
;; output from an n-bit ripple-carry adder, expressed in terms of the delays for
;; and-gates, or-gates, and inverters?

(ns sicp-mailonline.exercises.3-30
  (:require [sicp-mailonline.examples.3-3-4.wire :as wire]
            [sicp-mailonline.examples.3-3-4.circuits :as circ]))

(defn ripple-carry-adder [agenda a b s c]
  (when (not-empty a)
    (let [c-in (wire/make-wire)]
      (circ/full-adder agenda (first a) (first b) c-in (first s) c)
      (recur agenda (rest a) (rest b) (rest s) c-in))))
