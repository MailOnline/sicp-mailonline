;; 3.1.1 Local State Variables

(ns sicp-mailonline.examples.3_1_1)

(defn- valid-balance? [balance]
  (or ((complement neg?) balance)
      (throw (IllegalStateException. "Insufficient funds"))))

(defn make-withdraw [initial-balance]
  (let [balance (atom initial-balance :validator valid-balance?)]
    (fn [amount]
      (swap! balance - amount))))

(defn make-account [initial-balance]
  (let [balance (atom initial-balance :validator valid-balance?)]
    (letfn [(dispatch [m]
                      (cond (= m :withdraw) #(swap! balance - %)
                            (= m :deposit) #(swap! balance + %)
                            :else (throw (IllegalArgumentException.
                                          (str "Unknown request -- MAKE-ACCOUNT " m)))))]
      dispatch)))
