;; Example 2.1.3
;; Implementing cons, car, cdr without using any data structure at all
;; - only using procedures.

(ns sicp-mailonline.examples.2-1-3)

(defn cons [x y]
  (letfn [(dispatch [m]
            (cond (zero? m) x
                  (= m 1) y
                  :else (throw (IllegalArgumentException. "Argument not 0 or 1 -- CONS"))))]
    dispatch))

(defn car [z]
  (z 0))

(defn cdr [z]
  (z 1))
