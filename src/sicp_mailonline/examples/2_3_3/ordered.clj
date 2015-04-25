;; Example 2.3.3 Representing Sets
;; Sets as ordered lists

(ns sicp-mailonline.examples.2-3-3.ordered)

(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        (< x (first set)) false
        :else (recur x (rest set))))

(defn intersection-set [set1 set2]
  (if (or (empty? set1) (empty? set2))
    '()
    (let [x1 (first set1)
          x2 (first set2)]
      (cond (= x1 x2) (cons x1 (intersection-set (rest set1) (rest set2)))
            (< x1 x2) (recur (rest set1) set2)
            (< x2 x1) (recur set1 (rest set2))))))
