;; Example 3.3.5 Propagation of Constraints

(ns sicp-mailonline.examples.3-3-5.celsius-fahrenheit
  (:require [sicp-mailonline.examples.3-3-5.constraints :refer :all]))

;;; relation: 9C = 5(F - 32)
;;; constaint network:
;;;
;;;       -------   -------   v  -------
;;;   C---|m1   | u |   m1|------|a1   |
;;;       |  * p|---|p *  |      |  + s|---F
;;;    ---|m2   |   |   m2|--  --|a2   |
;;;    |  -------   ------- |  | -------
;;;   w|                    |  |
;;;    |   ---         --- x|  |y ----
;;;    ----|9|         |5|---  ---|32|
;;;        ---         ---        ----
;;;
(defn celsius-fahrenheit-converter [c f]
  (let [u (make-connector)
        v (make-connector)
        w (make-connector)
        x (make-connector)
        y (make-connector)]
    (multiplier c w u)
    (multiplier v x u)
    (adder v y f)
    (constant 9 w)
    (constant 5 x)
    (constant 32 y)
    'ok))
