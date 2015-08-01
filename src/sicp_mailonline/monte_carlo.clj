(ns sicp-mailonline.monte-carlo)

(defn monte-carlo [trials experiment]
  (letfn [(iter [trials-remaining trials-passed]
    (cond 
      (= trials-remaining 0) (/ trials-passed trials)
      (experiment) (recur (dec trials-remaining) (inc trials-passed))
      :else (recur (dec trials-remaining) trials-passed)))]
  (iter trials 0)))

