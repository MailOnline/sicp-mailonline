;; Exercise 2.24
;; Suppose we evaluate the expression (list 1 (list 2 (list 3 4))).
;; Give the result printed by the interpreter, the corresponding box-and-pointer
;; structure, and the interpretation of this as a tree (as in figure 2.6).

;; interpreter prints: (1 (2 (3 4)))

;; box-and-pointer-structure:
;;   (1 (2 (3 4)))    (2 (3 4))    (3 4)
;;     x o->            x o->       x o->      x o-> /            
;;     |                |           |          |
;;     1                2           3          4

;; interpretation as a tree:
;;           (1 (2 (3 4)))
;;           /         \   
;;          1        (2 (3 4))
;;                   /    \
;;                  2    (3 4)
;;                       /   \
;;                      3     4
