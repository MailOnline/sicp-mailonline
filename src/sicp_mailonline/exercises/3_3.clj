; 
; Exercise 3.3
;
(ns sicp-mailonline.exercises.3-3)

(defn make-account [initial-balance password]
  (let [balance (atom initial-balance)]
    (letfn [
        (withdraw [amount]
          (if (>= @balance amount)
            (swap! balance #(- % amount))
            "Insufficient funds"))

        (deposit [amount]
          (swap! balance #(+ % amount)))

        (execute [try-password m amount]
          (if (= try-password password)
            (condp = m
              :withdraw (withdraw amount)
              :deposit (deposit amount)
              :else { :error (str "Unknown request: MAKE-ACCOUNT" m)})
            "Incorrect password"))

        (dispatch [try-password m]
          (partial execute try-password m))]
    dispatch)))

(def acc (make-account 100 'secret-password))

(println ((acc 'secret-password :withdraw) 40))

(println ((acc 'some-other-password :deposit) 50))



