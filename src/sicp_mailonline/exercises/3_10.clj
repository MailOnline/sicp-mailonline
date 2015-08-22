;; Exercise 3.10
;; In the make-withdraw procedure, the local variable balance is created as a
;; parameter of make-withdraw.  We could also create the local state variable
;; explicitly, using let, as follows:
;;
;; (define (make-withdraw initial-amount)
;;   (let ((balance initial-amount))
;;     (lambda (amount)
;;             (if (>= balance amount)
;;               (begin (set! balance (- balance amount))
;;                      balance)
;;               "Insufficient funds"))))
;;
;; Recall from section 1.3.2 that let is simply syntactic sugar for a procedure
;; call:
;;
;; (let ((<var> <exp>)) <body>)
;;
;; is interpreted as an alternative syntax for
;;
;; ((lambda (<var>) <body>) <exp>)
;;
;; Use the environment model to analyze this alternate version of make-withdraw,
;; drawing figures like the ones above to illustrate the interactions
;;
;; (define W1 (make-withdraw 100))
;; (W1 50)
;; (define W2 (make-withdraw 100))
;;
;; Show that the two versions of make-withdraw create objects with the same
;; behaviour.  How do the environment structures differ for the two versions?

;; (define W1 (make-withdraw 100))
;;
;; global env |-----------------------------------------------------|
;;            | make-withdraw: *                                    |
;;            |                |   W1: *                            |
;;            |-----------------------------------------------------|
;;                             | ^     |                ^
;;                             v |     |                |
;; params: initial-amount      * *     | E1->|---------------------|
;; body: (let ((balance...             |     | initial-amount: 100 |
;;                                     |     |---------------------|
;;                                     |         ^         ^
;;                                     |         |         |
;;                                     | (let) * *         |          params: balance
;;                                     |                   |          body: (lambda (amount
;;                                     |                   |
;;                                     |       E2->|--------------|
;;                                     |           | balance: 100 |
;;                                     |           |--------------|
;;                                     |                ^
;;                                     |                |
;;                                     |    (lambda)  * *             params: amount
;;                                     |              ^               body: (if (>= balance
;;                                     |              |
;;                                     |---------------

;; (W1 50)
;;
;;              |                    after set!             |
;;              |                                           |
;;  E2->|--------------|                         E2->|-------------|
;;      | balance: 100 |                             | balance: 50 |
;;      |--------------|                             |-------------|
;;              ^                                           ^
;;              |                                           |
;;  E3->|------------|                           E3->|------------| 
;;      | amount: 50 |                               | amount: 50 |
;;      |------------|                               |------------|

;; (define W2 (make-withdraw 100))
;;
;; global env |-----------------------------------------------------------------------------------|
;;            | make-withdraw: *                                                                  |
;;            |                |   W1: *                          W2: *                           |
;;            |-----------------------------------------------------------------------------------|
;;                             | ^     |                ^             |
;;                             v |     |                |             |
;; params: initial-amount      * *     | E1->|---------------------|  | E3->|---------------------|
;; body: (let ((balance...             |     | initial-amount: 100 |  |     | initial-amount: 100 |
;;                                     |     |---------------------|  |     |---------------------|
;;                                     |         ^         ^          |             ^         ^
;;                                     |         |         |          |             |         |
;;                                     | (let) * *         |          |     (let) * *         |          
;;                                     |                   |          |                       |          
;;                                     |                   |          |                       |
;;                                     |       E2->|-------------|    |        E4->|--------------|
;;                                     |           | balance: 50 |    |            | balance: 100 |
;;                                     |           |-------------|    |            |--------------|
;;                                     |                ^             |                       ^
;;                                     |                |             |                       |
;;                                     |    (lambda)  * *             |           (lambda)  * *             
;;                                     |              ^               |                     ^               
;;                                     |              |               |                     |
;;                                     |---------------               |----------------------
