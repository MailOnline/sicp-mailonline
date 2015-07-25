; 
; Exercise 3.7
;
(ns sicp-mailonline.exercises.3-7)

(defn make-account-impl [balance password]
  (letfn [
      (balance-atom [] balance)

      (withdraw [amount]
        (if (>= @balance amount)
          (swap! balance #(- % amount))
          "Insufficient funds"))

      (deposit [amount]
        (swap! balance #(+ % amount)))

      (execute [try-password m amount]
        (if (= try-password password)
          (condp = m
            :-balance-atom (balance-atom)
            :withdraw (withdraw amount)
            :deposit (deposit amount)
            :else { :error (str "Unknown request: MAKE-ACCOUNT" m)})
          "Incorrect password"))

      (dispatch [try-password m]
        (partial execute try-password m))]
    dispatch))


(defn make-account [initial-balance password]
    (let [balance (atom initial-balance)]
      (make-account-impl balance password)))

(defn make-joint [account password new-password]
    (let [balance ((account password :-balance-atom) nil)]
      (make-account-impl balance new-password)))