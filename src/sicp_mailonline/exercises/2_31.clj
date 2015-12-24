;
; Exercise 2.31
;
(ns sicp-mailonline.exercises.2-31)

(defn tree-map [payload tree]
  (cond
    (nil? tree)         nil
    (not (coll? tree))  (payload tree)
    (empty? tree)       nil
    :else (cons (tree-map payload (first tree))
                (tree-map payload (rest tree)))))

(defn square-tree [tree]
  (tree-map #(* % %) tree))
