;; Example 2.2.2 Hierarchical Structures

(ns sicp-mailonline.examples.2-2-2)

(defn count-leaves [x]
  (cond (not (coll? x)) 1
        (empty? x) 0
        :else (+ (count-leaves (first x))
                 (count-leaves (rest x)))))
