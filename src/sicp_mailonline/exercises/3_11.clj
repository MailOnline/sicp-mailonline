;
; Exercise 3.11.
;
; The Clojure port requires an atom (as vars cannot be mutated) which introduces
; an extra frame to the environment. So answering the question based on the 
; original Scheme code
;
;
; (define (make-account ...
; :global { :make-account  [proc, :global ]}
; 
; (define acc (make-account 50))
;
; :global { :make-account  [proc, :global]
;           :acc           [proc  :E1 ]}
; :E1 { :balance 50  
;       :withdraw   [proc :E1]
;       :deposit    [proc :E1]
;       :dispatch   [proc :E1] 
;       :parent     :global}
;
; (acc 'deposit)
; :E2 { :m 'deposit :parent :E1 } }
; Retuns :deposit [proc :E1] from :E1 environment
; 
; (ret 40)
; :E3 { :amount 40 :parent :E1 }
; Then adjusts E1
; :E1 { :balance 90  <--- new value 
;       :withdraw   [proc :E1]
;       :deposit    [proc :E1]
;       :dispatch   [proc :E1] }
;
; (acc 'withdraw)
; :E4 { :m 'withdraw :parent :E1 } }
; Returns :withdraw proc :E1] from :E1 environment
; 
; (ret 60)
; :E5 { :amount 60 :parent :E1 } }
; Then adjusts E1
; :E1 { :balance 30  <--- new value 
;       :withdraw   [proc :E1]
;       :deposit    [proc :E1]
;       :dispatch   [proc :E1] }
;
; (define acc2 (make-account 100))
;
; :global { :make-account  [proc, :global]
;           :acc           [proc  :E1]
            :acc2          [proc :E6 ]}
; :E6 { :balance 50  
;       :withdraw   [proc :E1]
;       :deposit    [proc :E1]
;       :dispatch   [proc :E1] 
;       :parent     :global}
;
; Local states for acc and acc2 are kept distinct as state for acc is kept in 
; :E1 and state for acc2 is kept in :E2
;
; Both acc and acc2 share the global environment which contains definitions for 
; :make-account, :acc and :acc2


