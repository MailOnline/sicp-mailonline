; 
; Exercise 3.4
;
(ns sicp-mailonline.exercises.3-4)

(defn make-account [initial-balance password]
  (let [balance (atom initial-balance)
        invalid-access-attempts (atom 0)]
    (letfn [
        (withdraw [amount]
          (if (>= @balance amount)
            (swap! balance #(- % amount))
            "Insufficient funds"))

        (deposit [amount]
          (swap! balance #(+ % amount)))

        (call-the-cops []
          "Cops have been called")

        (execute [try-password m amount]          
          (if (= try-password password)
            (do 
              (reset! invalid-access-attempts 0)
              (condp = m
                :withdraw (withdraw amount)
                :deposit (deposit amount)
                :else { :error (str "Unknown request: MAKE-ACCOUNT" m)}))
            (do 
              (swap! invalid-access-attempts inc)
              (if (> @invalid-access-attempts 7)
                (call-the-cops)
                "Incorrect password"))))

        (dispatch [try-password m]
          (partial execute try-password m))]
    dispatch)))

(def acc (make-account 100 'secret-password))

(doseq [x (range 1 9)] 
  (do 
    (println (str "Attempt " x))
    (println ((acc 'some-other-password :deposit) 50))))
