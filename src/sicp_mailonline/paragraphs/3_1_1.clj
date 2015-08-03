(ns sicp-mailonline.paragraphs.3-1-1)

(defn make-withdraw [init]
  (let [balance (atom init)]
    (fn [amount]
      (if (>= @balance amount)
        (swap! balance #(- % amount))))))
