(ns sicp-mailonline.exercises.chapter1.1-4)

;; Observe that our model of evaluation allows for combinations whose operators are compound
;; expressions. Use this observation to describe the behaviour of the following procedure:

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))


;; Answer:
;; If b is greater than 0
;;    => then the operator is the plus symbol and the procedure adds the 2 operands
;;    => else the operator is the minus symbol and causes b to have an absolute value
;;       which in turn also adds the 2 operands

