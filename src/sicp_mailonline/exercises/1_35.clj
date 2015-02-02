(ns sicp-mailonline.exercises.1-35
  (:require [sicp-mailonline.paragraphs.1-3-3 :as p]))

; show that the golden ration is a fixed opint of: x -> 1 + 1/x
; a fixed point is that value of x so that the two sides of the above transformation are the same
; we can show that x -> 1 + 1/x is equivalent to x^2 = x + 1, which as shown in 1.2.2 is solved
; by the golden ratio.

; so: x->1+1/x => x/x + 1/x => (x+1)/x
; now moving the /x divisor on the other side
; x^2 -> x + 1
; that is the equation for which the golden ratio is true

(defn golden-ratio []
  (p/fixed-point (fn [x] (p/average x (+ 1 (/ 1 x)))) 1.0))
