;; Exercise 3.4
;; Modify the make-account procedure of exercise 3.3 by adding another local
;; state variable so that, if an account is accessed more than seven consecutive
;; times with an incorrect password, it invokes the procedure call-the-cops.

(ns sicp-mailonline.exercises.3-4)

(def ^:private ^:const bad-pwd-limit 7)

(defn- valid-balance? [balance]
  (or ((complement neg?) balance)
      (throw (IllegalStateException. "Insufficient funds"))))

(defn- watch-bad-passwords [ref f]
  (letfn [(watch [key ref old-count new-count]
                 (when (>= new-count bad-pwd-limit)
                   (f)))]
    (add-watch ref :watch-bad-passwords watch)))

(defn make-account [initial-balance account-password call-cops]
  (let [balance (atom initial-balance :validator valid-balance?)
        bad-pwd-count (atom 0)]
    (letfn [(authorise-transaction [f amount]
                                   (reset! bad-pwd-count 0)
                                   (swap! balance f amount))
            (block-transaction []
                               (swap! bad-pwd-count inc)
                               "Incorrect password")
            (secure-transaction [f password amount]
                                (if (= password account-password)
                                  (authorise-transaction f amount)
                                  (block-transaction)))            
            (dispatch [password method]
                      (cond (= method :withdraw) (partial secure-transaction - password)
                            (= method :deposit) (partial secure-transaction + password)
                            :else (throw (IllegalArgumentException.
                                          (str "Unknown request -- MAKE-ACCOUNT " method)))))]
      (watch-bad-passwords bad-pwd-count call-cops)
      dispatch)))
