(ns sicp-mailonline.exercises.3-4)

(defn make-account [init pwd]
  (let [cnt (atom 7)
        balance (atom init)
        stored pwd]
    (fn [amount pwd]
      (cond
        (not= pwd stored)
        (do
          (swap! cnt dec)
          (if (zero? @cnt)
            "calling the cops"
            (format "You have %s more attempts" @cnt)))
        (< @balance amount)
        "No way."
        :else
        (do (reset! cnt 7) (swap! balance #(- % amount)))))))
