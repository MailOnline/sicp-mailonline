;; Exercise 2.62
;; Give a O(n) implementation of union-set for sets represented as ordered lists.

(ns sicp-mailonline.exercises.2-62)

(defn union-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        (= (first set1) (first set2)) (cons (first set1)
                                            (union-set (rest set1) (rest set2)))
        (< (first set1) (first set2)) (cons (first set1)
                                            (union-set (rest set1) set2))
        :else (cons (first set2)
                    (union-set set1 (rest set2)))))
