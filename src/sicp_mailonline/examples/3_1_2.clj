;; 3.1.2 : The Benefits Of Introducing Assignment

(ns sicp-mailonline.examples.3-1-2)

(defn monte-carlo [trials experiment]
  (letfn [(iter [trials-remaining trials-passed]
                (cond (zero? trials-remaining) (/ trials-passed trials)
                      (experiment) (recur (dec trials-remaining) (inc trials-passed))
                      :else (recur (dec trials-remaining) trials-passed)))]
    (iter trials 0)))
