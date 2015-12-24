; 
; Exercise 3.10
;
(ns sicp-mailonline.exercises.3-10)

(defn make-withdraw [initial-balance]
  ((fn [balance]
    (fn [amount]
      (if (>= @balance amount)
        (swap! balance #(- % amount))
        "Insufficient funds"))) 
   (atom initial-balance)))

(def W1 (make-withdraw 100))

(println (W1 50))

(def W2 (make-withdraw 100))

;
; :global { :make-withdraw  [proc :global] } 
; 
; (def W1 (make-withdraw 100))
; :E1 { :initial-balance :parent :global }
; :E2  { :balance (atom 100) :parent :E1 }
; :global { :make-withdraw  [proc :global] 
;           :W1             [proc :E2] }
;  
; (println (W1 50))
; :E3  { :amount 50 :parent  :E2 }
; :E2  { :balance (atom 500) :parent :global }
;
; (def W2 (make-withdraw 100))
; ;E4 { :initial-balance :parent :global }
; :E5 { :balance (atom 100) :parent :E4 }
; :global { :make-withdraw  [proc :global] 
;           :W1             [proc :E2] 
;           :W2             [proc :E5] }
; 
; New version has an extra frame (:E1 :E3) between the environment of the account 
; and the global account. As the code does not refer to the variable :initial-balance
; in :E1 and E3, the objects in effect treat the environment the same way.
;
; The procedure part of the objects (i.e. the inner lambda) is identical. As the 
; enivronment behaves the same way and the procedure is identical, the objects
; have the same behaviour.
;


