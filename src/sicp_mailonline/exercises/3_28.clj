;; Exercise 3.28
;; Define an or-gate as a primitive function box.  Your or-gate constructor
;; should be similar to an and-gate.

(ns sicp-mailonline.exercises.3-28
  (:require [sicp-mailonline.examples.3-3-4.wire :as wire]
            [sicp-mailonline.examples.3-3-4.simulation :as sim]))

(def ^:private ^:const or-gate-delay 5)

(defn or-gate [agenda i1 i2 output]
  (letfn [(or-action-procedure []
            (let [new-value (bit-or (wire/get-signal i1)
                                    (wire/get-signal i2))]
              (sim/after-delay agenda
                               or-gate-delay
                               #(wire/set-signal! output new-value))))]
    (wire/add-action! i1 or-action-procedure)
    (wire/add-action! i2 or-action-procedure)))
