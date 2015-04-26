;; Example 2.3.3 Representing Sets
;; Sets as binary trees

(ns sicp-mailonline.examples.2-3-3.tree)

(defn entry [tree]
  (first tree))

(defn left-branch [tree]
  (first (rest tree)))

(defn right-branch [tree]
  (second (rest tree)))

(defn make-tree [entry left right]
  (list entry left right))

(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (entry set)) true
        (< x (entry set)) (recur x (left-branch set))
        (> x (entry set)) (recur x (right-branch set))))

(defn adjoin-set [x set]
  (cond (empty? set) (make-tree x
                                '()
                                '())
        (= x (entry set)) set
        (< x (entry set)) (make-tree (entry set)
                                     (adjoin-set x (left-branch set))
                                     (right-branch set))
        (> x (entry set)) (make-tree (entry set)
                                     (left-branch set)
                                     (adjoin-set x (right-branch set)))))
