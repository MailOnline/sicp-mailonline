(ns sicp-mailonline.exercises.2-19)

;; reversed to see the effect. No effect. Then looking at it,
;; can't see a good reason why it should have any effect. Every denomination is
;; processed without effects on the others once it is excluded from the list,
;; which happens at each recursion cycle.
(def us-coins (reverse (list 50 25 10 5 1)))
(def uk-coins (list 100 50 20 10 5 2 1 0.5))

(defn no-more? [coin-values]
  (empty? coin-values))

(defn except-first-denomination [coin-values]
  (rest coin-values))

(defn first-denomination [kinds-of-coins]
  (first kinds-of-coins))

(defn cc [amount coin-values]
  (cond (= amount 0) 1
        (or (< amount 0) (no-more? coin-values)) 0
        :else (+ (cc amount
                     (except-first-denomination coin-values))
                 (cc (- amount
                        (first-denomination coin-values))
                     coin-values))))
