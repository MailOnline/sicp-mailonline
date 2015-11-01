;; Exercise 3.35
;; Ben Bitdiddle tells Louis that one way to avoid the trouble in exercise 3.34
;; is to define a squarer as a new primitive constraint.  Fill in the missing
;; portions in Ben's outline for a procedure to implement such a constraint:
;;
;; (define (squarer a b)
;;   (define (process-new-value)
;;     (if (has-value? b)
;;       (if (< (get-value b) 0)
;;         (error "square less than 0 -- SQUARER" (get-value b))
;;         <alternative1>)
;;       <alternative2>))
;;   (define (process-forget-value)
;;     <body1>)
;;   (define (me request)
;;     <body2>)
;;   <rest of definition>
;;   me)

(ns sicp-mailonline.exercises.3-35
  (:require [sicp-mailonline.examples.3-3-5.constraints :as con]))

(defn squarer [a b]
  (letfn [(square [n]
            (* n n))
          (process-new-value []
            (if (con/has-value? b)
              (if (< (con/get-value b) 0)
                (throw (IllegalStateException.
                        (str "square less than 0 -- SQUARER"
                             (con/get-value b))))
                (con/set-value! a (Math/sqrt (con/get-value b)) me)))
            (if (con/has-value? a)
              (con/set-value! b (square (con/get-value a)) me)))
          (process-forget-value []
            (con/forget-value! a me)
            (con/forget-value! b me)
            (process-new-value))
          (me [request]
            (cond (= request :I-have-a-value)
                    (process-new-value)
                  (= request :I-lost-my-value)
                    (process-forget-value)
                  :else (throw (IllegalArgumentException.
                                (str "Unknown request -- SQUARER" request)))))]
    (con/connect a me)
    (con/connect b me)
    me))
