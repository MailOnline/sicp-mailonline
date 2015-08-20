;
; Exercise 2.30
;

(ns sicp-mailonline.exercises.2-30)


(defn square-tree-1 [tree]
  (cond
    (nil? tree)         nil
    (not (coll? tree))  (* tree tree)
    (empty? tree)       nil
    :else (cons (square-tree-1 (first tree))
                (square-tree-1 (rest tree)))))


(defn square-tree-2 [tree]
  (map (fn [sub-tree]
          (if (coll? sub-tree)
              (square-tree-2 sub-tree)
              (* sub-tree sub-tree)))
          tree))
