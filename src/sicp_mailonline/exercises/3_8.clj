;; Exercise 3.8
;; When we defined the evaluation model in section 1.1.3, we said that the first
;; step in evaluating an expression is to evaluate its subexpressions.  But we
;; never specified the order in which the subexpressions should be evaluated
;; (e.g., left to right or right to left).  When we introduce assignment, the
;; order in which the arguments to a procedure are evaluated can make a
;; difference to the result.  Define a simple procedure f such that evaluating
;; (+ (f 0) (f 1)) will return 0 if the arguments to + are evaluated from left
;; to right but will return 1 if the arguments are evaluated from right to left.

(ns sicp-mailonline.exercises.3-8)

;; f returns the arg x the first time it is invoked, otherwise it returns 0
(defn make-f []
  (let [initial-value (atom nil)]
    (fn [x]
      (if @initial-value
        0
        (swap! initial-value #(identity %2) x)))))
