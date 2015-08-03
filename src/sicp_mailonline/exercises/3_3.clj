(ns sicp-mailonline.exercises.3-3)

(defn make-account [init pwd]
  (let [balance (atom init)
        stored pwd]
    (fn [amount pwd]
      (cond
        (not= pwd stored) "You little chipmunk."
        (< @balance amount) "No way."
        :else (swap! balance #(- % amount))))))
