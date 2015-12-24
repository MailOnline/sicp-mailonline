; 
; Exercise 3.9
;
(ns sicp-mailonline.exercises.3-9)

(defn factorial [n]
  (if (= n 1)
    1
    (* n (factorial (dec n)))))

;
; Evaluation (factorial 6)
;
; Global frame - { :factorial [factorial body/args global frame]}
;
; Evaulate sub exprssions
; Lookup factorial in current frame (:global)
; 6 is a primitive
;
; Apply (factorial 6)
; New frame :E1 { :n 6 :parent :global}  - :parent comes from definition of global
; Evaluate body of factorial 6
; 
; Evaluate (factorial (dec 6)) - n has come from E1
; Look up factorial in current frame :E1 - gives factorial in :global
; Evaluate (dec 6) primitive => 5
; Apply (factorial 5)
; New frame :E2 { :n 5 :parent :global} etc.
;
; Until apply (factorial 1) which returns 1
; Multiplications happen on return stack - not covered in this model 
;
; So basically a linked list of frames :E5, :E4, :E3, :E2, :E1 all pointing to :global

(defn fact-iter [product counter max-count]
  (if (> counter max-count)
    product
    (recur (* counter product) (inc counter) max-count)))

(defn factorial [n] (fact-iter 1 1 n))

;
; Evaluation (factorial 6)
;
;  Global frame - { :factorial [factorial body/args global frame] 
;                   :fact-iter [factorial body/args global frame] }
;
; Evaluate sub-expressions
; Lookup factorial in current frmae (:global)
; 6 is primitive
;
; Apply (factorial 6)
; New frame :E1 { :n 6 :parent :global}
; Evaluate body of factorial 6
;
; Evaluate (fact-inter 1 1 6)
; evaluate sub-expressions
; Look up fact-inter in :E1, need to go to :global
; 
; Apply (fact-inter 1 1 6)
; New frame :E2 { :product 1 :counter 1 :max-count 6 :parent :global}
; Evaluate body (fact-inter 1 1 6) in :E2
;
; Evaluate (fact-iter (* 1 1) (inc 1) 6)
; Evaluate sub-expressions
; fact-iter looked up in :E2 -> :global
;
; Apply (fact-iter 1 2 6)
; New frame :E3 { :product 1 :counter 1 :max-count 6 :parent :global }
;
; etc


; Both factorials - frames :E1, :E2 point at :global
; Recursive contain just :n and :parent
; Iterative contain :product :counter :max-count :parent
; Recursive :E1,...,:E5 have to be kept around until it start to unwind
; Iterative - once :E3 is created :E2 can be discarded etc.

 





