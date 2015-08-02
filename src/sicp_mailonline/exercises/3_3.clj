;; Exercise 3.3
;; Modify the make-account procedure so that it creates password-protected
;; accounts.  That is, make-account should take a symbol as an additional
;; argument, as in
;;
;; (define acc (make-account 100 'secret-password))
;;
;; The resulting account object should process a request only if it is
;; accompanied by the password with which the account was created, and should
;; otherwise return a complaint:
;;
;; ((acc 'secret-password 'withdraw) 40)
;; -> 60
;;
;; ((acc 'some-other-password 'deposit) 50)
;; -> "Incorrect password"

(ns sicp-mailonline.exercises.3-3)

(defn- valid-balance? [balance]
  (or ((complement neg?) balance)
      (throw (IllegalStateException. "Insufficient funds"))))

(defn make-account [initial-balance account-password]
  (let [balance (atom initial-balance :validator valid-balance?)]
    (letfn [(secure-transaction [f password amount]
                                (if (= password account-password)
                                  (swap! balance f amount)
                                  "Incorrect password"))
            (dispatch [password method]
                      (cond (= method :withdraw) (partial secure-transaction - password)
                            (= method :deposit) (partial secure-transaction + password)
                            :else (throw (IllegalArgumentException.
                                          (str "Unknown request -- MAKE-ACCOUNT " method)))))]
      dispatch)))
