; Exercise 2.26

(def x (list 1 2 3))
(def y (list 4 5 6))

(concat x y)
; (1 2 3 4 5 6)
; x and y are concatenated together - so the list is flattened
; Note concat is the Clojure version of append

(cons x y)
;((1 2 3) 4 5 6)
; Cons creates a list with the element x as the head element and y as the tail
; of the list

(list x y)
;((1 2 3) (4 5 6))
; List creates a list consisting of the two elements x and y. If x and y are
; lists this creates a nested structure.


