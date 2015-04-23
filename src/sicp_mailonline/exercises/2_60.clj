;; Exercise 2.60
;; We specified that a set would be represented as a list with no duplicates.
;; Now suppose we allow duplicates.  For instance, the set {1,2,3} could be
;; represented as the list (2 3 2 1 3 2 2).  Design procedures element-of-set?,
;; adjoin-set, union-set, and intersection-set that operate on this
;; representation.  How does the efficiency of each compare with the
;; corresponding procedure for the non-duplicate representation?  Are there
;; applications for which you would use this representation in preference to the
;; non-duplicate one?

(ns sicp-mailonline.exercises.2-60)

;; This implementation is unchanged from that for no-duplicate sets.
;; It is less efficient however, as it is likely to need to visit more elements
;; to determine membership given the existence of duplicates.
(defn element-of-set? [x set]
  (cond (empty? set) false
        (= (first set) x) true
        :else (recur x (rest set))))

;; This implementation is more efficient than that for no-duplicate sets, as it
;; does not need to test for membership (thereby avoiding a potential traversal
;; of the entire set).  It has O(1) complexity for number of steps.
(defn adjoin-set [x set]
  (cons x set))

;; This implementation is more efficient than that for no-duplicate sets, as it
;; does not need to test for membership.  It has O(n) complexity for number of
;; steps.  
(defn union-set [set1 set2]
  (concat set1 set2))

;; This implementation is unchanged from that for no-duplicate sets.
;; It is less efficient however, as it is likely to need to visit more elements
;; to determine membership given the existence of duplicates.
(defn intersection-set [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        (element-of-set? (first set1) set2)
          (cons (first set1) (intersection-set (rest set1) set2))
        :else (recur (rest set1) set2)))


;; If your application is biased towards modifying the set with adjoin-set, or
;; determining the union-set, rather than testing for set membership and
;; displaying the distinct elements, then you may want to consider this
;; implementation over the no-duplicates implementation.  You should consider
;; whether you can tolerate the additional memory required by the duplicates.
