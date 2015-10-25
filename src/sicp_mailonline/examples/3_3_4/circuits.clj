;; Example 3.3.4 - A Simulator for Digital Circuits

(ns sicp-mailonline.examples.3-3-4.circuits
  (:require [sicp-mailonline.examples.3-3-4.wire :as wire]
            [sicp-mailonline.examples.3-3-4.simulation :as sim]
            [sicp-mailonline.exercises.3-28 :refer :all]))

(def ^:private ^:const inverter-delay 2)
(def ^:private ^:const and-gate-delay 3)

(defn inverter [agenda input output]
  (letfn [(invert-input []
            (let [new-value (bit-flip (wire/get-signal input) 0)]
              (sim/after-delay agenda
                               inverter-delay
                               #(wire/set-signal! output new-value))))]
    (wire/add-action! input invert-input)))

(defn and-gate [agenda i1 i2 output]
  (letfn [(and-action-procedure []
            (let [new-value (bit-and (wire/get-signal i1)
                                     (wire/get-signal i2))]
              (sim/after-delay agenda
                               and-gate-delay
                               #(wire/set-signal! output new-value))))]
    (wire/add-action! i1 and-action-procedure)
    (wire/add-action! i2 and-action-procedure)))

(defn half-adder [agenda a b s c]
  (let [d (wire/make-wire)
        e (wire/make-wire)]
    (or-gate agenda a b d)
    (and-gate agenda a b c)
    (inverter agenda c e)
    (and-gate agenda d e s)
    'ok))

(defn full-adder [agenda a b c-in sum c-out]
  (let [s (wire/make-wire)
        c1 (wire/make-wire)
        c2 (wire/make-wire)]
    (half-adder agenda b c-in s c1)
    (half-adder agenda a s sum c2)
    (or-gate agenda c1 c2 c-out)
    'ok))
