;; Exercise 2.61
;; Give an implementation of adjoin-set using the ordered representation.  By
;; analogy with element-of-set? show how to take advantage of the ordering to
;; produce a procedure that requires on the average about half as many steps as
;; with the unordered representation.

(ns sicp-mailonline.exercises.2-61)

(defn adjoin-set [x set]
  (cond (empty? set) (list x)
        (< x (first set)) (cons x set)
        (= x (first set)) set
        :else (cons (first set) (adjoin-set x (rest set)))))

;; In the worst case, we have to walk the entire set to add at the end.  On
;; average, we should expect to traverse half of the elements of the set,
;; resulting in n/2 steps.  This is still O(n) growth, but it does save a factor
;; of 2 in the number of steps.
