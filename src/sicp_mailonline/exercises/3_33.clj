;; Exercise 3.33
;; Using primitive multiplier, adder, and constant constraints, define a
;; procedure averager that takes three connectors a, b, and c as inputs and
;; establishes the constraint that the value of c is the average of the values
;; of a and b.

(ns sicp-mailonline.exercises.3-33
  (:require [sicp-mailonline.examples.3-3-5.constraints :as con]))

(defn averager [a b c]
  (let [sum (con/make-connector)
        half (con/make-connector)]
    (con/adder a b sum)
    (con/constant 1/2 half)
    (con/multiplier sum half c)
    'ok))
