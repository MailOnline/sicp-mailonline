; 
; Exercise 2.19
;
(ns sicp-mailonline.exercises.2-19)

(defn first-denomination [coin-values]
  (first coin-values))

(defn except-first-denomination [coin-values]
  (rest coin-values))

(defn no-more? [coin-values]
  (= (first coin-values) nil)) 

(defn cc [amount coin-values]
 ; (println "cc" amount coin-values)
  (cond (= amount 0)                     1
        (or (< amount 0) 
            (no-more? coin-values))      0
        :else 
         (+ (cc amount
                (except-first-denomination coin-values))
            (cc (- amount (first-denomination coin-values))
                coin-values))))

(def us-coins 
  ; you have pennies, nickels, dimes, quarters and half-dollars
  '(50 25 10 5 1))

(def us-coins-alternative-order
  '(10 25 5 1 50))

(def uk-coins
  '(100 50 20 10 5 2 1 0.5))


(defn count-change-us [amount]
  (cc amount us-coins))

; Order of the coins does not affect the result. Why? Well the proof that the
; algorithm works is by induction and does not rely on the order of the
; coins.




