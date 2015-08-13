;; Exercise 3.9
;; In section 1.2.1 we used the substitution model to analyze two procedures for
;; computing factorials, a recursive version
;;
;; (define (factorial n)
;;   (if (= n 1)
;;     1
;;     (* n (factorial (- n 1)))))
;;
;; and an interative version
;;
;; (define (factorial n)
;;   (fact-iter 1 1 n))
;;
;; (define (fact-iter product counter max-count)
;;   (if (> counter max-count)
;;     product
;;     (fact-iter (* counter product)
;;                (+ counter 1)
;;                max-count)))
;;
;; Show the environment structures created by evaluating (factorial 6) using
;; each version of the factorial procedure.

;; recursive
;;
;;             params: n
;;             body: (if (= n 1)...
;;               ^
;;               |
;;               v
;;           ---------------------------------------------------------------------------------
;; global    | factorial                                                                     |
;; env       |                                                                               |
;;           ---------------------------------------------------------------------------------
;;                  ^             ^             ^             ^             ^             ^
;;                  |             |             |             |             |             |
;;           E1->[ n:6 ]   E2->[ n:5 ]   E3->[ n:4 ]   E4->[ n:3 ]   E5->[ n:2 ]   E6->[ n:1 ] 

;; iterative
;;
;;             params: n                     params: product,counter,max-count
;;             body: (fact-iter...           body: (if (> counter max-count...
;;               ^                             ^ 
;;               |                             |
;;               v                             v
;;           -----------------------------------------------------------------------------------------------------------------------------------------------
;; global    | factorial                   fact-iter                                                                                                       |
;; env       |                                                                                                                                             |
;;           -----------------------------------------------------------------------------------------------------------------------------------------------
;;                  ^               ^                     ^                     ^                     ^                     ^                     ^
;;                  |               |                     |                     |                     |                     |                     |
;;           E1->[ n:6 ]   E2->[ product:1   ]   E3->[ product:1   ]   E4->[ product:2   ]   E5->[ product:6   ]   E6->[ product:24  ]   E7->[ product:120 ] 
;;                             [ counter:1   ]       [ counter:2   ]       [ counter:3   ]       [ counter:4   ]       [ counter:5   ]       [ counter:6   ]
;;                             [ max-count:6 ]       [ max-count:6 ]       [ max-count:6 ]       [ max-count:6 ]       [ max-count:6 ]       [ max-count:6 ]
