;; Example 2.3.3 Representing Sets
;; Sets as unordered lists

(ns sicp-mailonline.examples.2-3-3)

(defn element-of-set? [x set]
  (cond (empty? set) false
        (= (first set) x) true
        :else (recur x (rest set))))

(defn adjoin-set [x set]
  (if (element-of-set? x set)
    set
    (cons x set)))

(defn intersection-set [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        (element-of-set? (first set1) set2)
          (cons (first set1) (intersection-set (rest set1) set2))
        :else (recur (rest set1) set2)))
