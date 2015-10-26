;; Exercise 3.29
;; Another way to construct an or-gate is as a compound digital logic device,
;; built from and-gates and inverters.  Define a procedure or-gate that
;; accomplishes this.  What is the delay time of the or-gate in terms of
;; and-gate-delay and inverter-delay?

(ns sicp-mailonline.exercises.3-29
  (:require [sicp-mailonline.examples.3-3-4.wire :as wire]
            [sicp-mailonline.examples.3-3-4.circuits :as circ]))

;; De-Morgan's Laws: i1 or i2 = not ((not i1) and (not i2))
(defn or-gate [agenda i1 i2 output]
  (let [d (wire/make-wire)
        e (wire/make-wire)
        f (wire/make-wire)]
    (circ/inverter agenda i1 d)
    (circ/inverter agenda i2 e)
    (circ/and-gate agenda d e f)
    (circ/inverter agenda f output)))

;; delay = and-gate-delay + (2 * inverter-gate-delay)
