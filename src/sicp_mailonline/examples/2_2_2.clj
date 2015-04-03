;; Example 2.2.2 Hierarchical Structures

(ns sicp-mailonline.examples.2-2-2)

(defn count-leaves [x]
  (cond (not (coll? x)) 1
        (empty? x) 0
        :else (+ (count-leaves (first x))
                 (count-leaves (rest x)))))

(defn recursive-scale-tree [tree factor]
  (cond (not (coll? tree)) (* tree factor)
        (empty? tree) '()
        :else (cons (recursive-scale-tree (first tree) factor)
                    (recursive-scale-tree (rest tree) factor))))

(defn map-scale-tree [tree factor]
  (map (fn [sub-tree]
         (if (coll? sub-tree)
           (map-scale-tree sub-tree factor)
           (* sub-tree factor)))
       tree))
