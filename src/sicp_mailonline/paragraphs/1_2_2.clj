; 
; Paragraph 1.2.2
;
(ns sicp-mailonline.core)


; Takes as an input the number of kinds of coins available
; and returns the denomination of the first kind - where
; the coins are arranged in order largest first
(defn first-denomination [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 5
        (= kinds-of-coins 3) 10
        (= kinds-of-coins 4) 25
        (= kinds-of-coins 5) 50))

(defn cc [amount kinds-of-coins]
  (cond (= amount 0)               1
        (or (< amount 0) 
            (= kinds-of-coins 0))  0
        :else 
         (+ (cc amount
                (- kinds-of-coins 1))
            (cc (- amount (first-denomination kinds-of-coins))
                kinds-of-coins))))

; Counts number of ways to make change assuming that
; you have pennies, nickels, dimes, quarters and half-dollars
(defn count-change [amount]
  (cc amount 5))




