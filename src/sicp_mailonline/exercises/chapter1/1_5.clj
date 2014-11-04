(ns sicp-mailonline.exercises.chapter1.1-5)

;; Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with
;; is using applicative-order evaluation or normal-order evaluation. He defines the
;; following two procedures:

(defn p []
  (p))

(defn test [x y]
  (if (= x 0)
    0
    y))

;; Then he evalutes the expression:

(test 0 (p))

;; What behaviour will Ben observe with an interpreter that uses applicative-order evaluation?

;; Answer:
;; With applicative-order evaluation, the arguments in the call to test will be fully evaluated
;; so they could replace (be substituted for) the formal parameters in the test procedure.
;; However, the evaluation of the p procedure would lead to an infinite recursive loop and
;; ultimately cause a stack overflow.



;; What behaviour will he observe with an interpreter that uses normal-order evaluation?

;; Answer:
;; With normal-order evaluation, the arguments in the call to test would not be evaluated until
;; their values were needed. Instead, the full operand expressions (rather than their evaluated
;; values) would be subsituted for the formal parameters in test. The (p) procedure would replace
;; the y formal parameter in test.
;;         => If x were equal to 0, then y would never be evaluated and
;;            hence the procedure would return 0 correctly.
;;         => Only if x were not equal to 0, would y be evaluated and
;;            hence would the stack overflow occur.
