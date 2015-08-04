(ns sicp-mailonline.exercises.3-7)

(defn make-account [init pwd-init]
  (let [balance (atom init)]
    (fn [amount pwd]
      (cond
        (not= pwd pwd-init) "You little chipmunk."
        (< @balance amount) "No way."
        :else (swap! balance #(- % amount))))))

(defn make-joint [acc pwd-orig pwd-new]
  (fn [amount pwd]
    (if (not= pwd pwd-new)
      "call the cops"
      (acc amount pwd-orig))))
