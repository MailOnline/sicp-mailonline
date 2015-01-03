(ns sicp-mailonline.exercises.1-14)

(defn- log [logger info]
  (when logger (swap! logger conj info)))

(defn first-denomination [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 5
        (= kinds-of-coins 3) 10
        (= kinds-of-coins 4) 25
        (= kinds-of-coins 5) 50))

(defn cc [amount kinds-of-coins & [logger]]
  (log logger [amount kinds-of-coins])
  (cond (= amount 0) 1
        (or (< amount 0) (= kinds-of-coins 0)) 0
        :else (+ (cc amount (- kinds-of-coins 1) logger)
                 (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins logger))))

(defn count-change [amount & [logger]]
  (cc amount 5 logger))
