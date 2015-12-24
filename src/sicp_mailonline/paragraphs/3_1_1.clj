(ns sicp-mailonline.paragraphs.3-1-1)

(def balance 100)

(defn withdraw [amount]
  (if (>= balance amount)
    (do (alter-var-root #'balance #(- % amount)) 
        balance)
    "Insufficent funds"))

(println (withdraw 25))

(println (withdraw 25))

(println (withdraw 60))

(println (withdraw 15))

(defn new-withdraw []
  (let [balance (atom 200)]
    (fn [amount]
      (if (>= @balance amount)
        (do 
          (swap! balance #(- % amount))
          @balance)
        "Insufficient funds"))))

(defn new-withdraw []
  (let [balance (atom 100)]
    (fn [amount]
      (if (>= @balance amount)
        (swap! balance #(- % amount))
        "Insufficient funds"))))

(defn make-withdraw [initial-balance]
  (let [balance (atom initial-balance)]
    (fn [amount]
      (if (>= @balance amount)
        (swap! balance #(- % amount))
        "Insufficient funds"))))

(println "New withdraw")

(def W1 (make-withdraw 100))

(def W2 (make-withdraw 100))

(doseq [e [(W1 50) (W2 70) (W2 40) (W1 40)]]  (println e))


(defn make-account [initial-balance]
  (let [balance (atom initial-balance)]
    (letfn [(withdraw [amount]
          (if (>= @balance amount)
            (swap! balance #(- % amount))
            "Insufficient funds"))

        (deposit [amount]
          (swap! balance #(+ % amount)))

        (dispatch [m]
          (condp = m
            :withdraw withdraw
            :deposit deposit
            :else { :error (str "Unknown request: MAKE-ACCOUNT" m)}))]
    dispatch)))


(println "Make account")

(def acc (make-account 100))

(doseq [e [
  ((acc :withdraw) 50)
  ((acc :withdraw) 60)
  ((acc :deposit) 40)
  ((acc :withdraw) 60)
]]  (println e))

(def acc2 (make-account 100))

