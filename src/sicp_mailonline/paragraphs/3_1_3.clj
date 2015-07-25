;
; Paragraph 3.1.3
;
(ns sicp-mailonline.paragraphs.3-1-3)

(defn make-simplified-withdraw[init-balance]
  (let [balance (atom init-balance)]
    (fn [amount]
      (swap! balance #(- % amount)))))

(def w (make-simplified-withdraw 25))

(println (w 20))
(println (w 10))


(defn make-decrementer [balance]
  (fn [amount]
      (- balance amount)))




