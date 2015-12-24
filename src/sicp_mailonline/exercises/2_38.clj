(ns sicp-mailonline.exercises.2-38
  (:require [sicp-mailonline.paragraphs.2-2-3 :refer [s-accumulate]]))

(def fold-right s-accumulate)


(defn fold-left [op initial sequence]
  (letfn [(iter [result remainder]
    (if (empty? remainder)
        result
        (recur (op result (first remainder)) (rest remainder))))]
  
    (iter initial sequence)))


; Fold-left - (op accumulation element)
; Fold-right - (op element accumulation)

(println (fold-left / 1 (list 1 2 3)))
; (((1 / 1) / 2) / 3) = 1/6

(println (fold-right / 1 (list 1 2 3)))
; (1 /(2 / (3 / 1)) = 3/2

(println (fold-right (fn [a b] (/ b a)) 1 (list 1 2 3)))
; (((1 / 3) / 2) / 1) = 6

; Differences are due to / not being associative
; and fold-left and fold-right reversing order of


(println (fold-right list nil (list 1 2 3)))
;(1 (2 (3 nil)))

(println (fold-left list nil (list 1 2 3)))
; (((nil 1) 2) 3)

; Op has to be associative (a . (b . c)) = ((a . b) . c) 
; but does not have to be commutative (a . b) = (b . a) and a

; Below is an example (https://en.wikipedia.org/wiki/Commutative_property#Associativity) is
; an example of a function that is commutative but not associative

(println (fold-left (fn [x y] (/ (+ x y) 2)) (/ 1 2) (list -4 4)))
; 9/8

(println (fold-right (fn [x y] (/ (+ x y) 2)) (/ 1 2) (list -4 4)))
; -7/8

; associative but not commutative
; e.g. concat 
; concat (concat '(1) '(2)) '(3))
; (1 2 3)
; (concat '(1) (concat '(2) '(3)))
; (1 2 3)
; (concat '(1) '(2)) 
;(1 2)
;(concat '(2) '(1))
; (2 1)

(println (fold-left concat nil (list '(1) '(2) '(3))))
; (1 2 3)
(println (fold-right concat nil (list '(1) '(2) '(3))))
; (1 2 3)







