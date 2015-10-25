;; Example 3.3.4 - A Simulator for Digital Circuits

(ns sicp-mailonline.examples.3-3-4-test
  (:require [sicp-mailonline.examples.3-3-4.simulation :as sim]
            [sicp-mailonline.examples.3-3-4.wire :as wire]
            [sicp-mailonline.examples.3-3-4.circuits :as circ]))

(def the-agenda (sim/make-agenda))

(def input-1 (wire/make-wire))
(def input-2 (wire/make-wire))
(def sum (wire/make-wire))
(def carry (wire/make-wire))

(sim/probe 'sum the-agenda sum)
;; -> sum 0 new-value=0

(sim/probe 'carry the-agenda carry)
;; -> carry 0 new-value=0

(circ/half-adder the-agenda input-1 input-2 sum carry)
(wire/set-signal! input-1 1)
(sim/propagate the-agenda)
;; -> sum 8 new-value=1

(wire/set-signal! input-2 1)
(sim/propagate the-agenda)
;; -> carry 11 new-value=1
;; -> sum 16 new-value=0
