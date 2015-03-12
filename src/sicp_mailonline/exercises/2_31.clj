;; Exercise 2.31
;; Abstract your answer to exercise 2.30 to produce a procedure tree-map with the
;; property that square-tree could be defined as
;;
;;   (define (square-tree tree) (tree-map square tree))

(ns sicp-mailonline.exercises.2-31)

(defn tree-map-a [f tree]
  (cond (empty? tree) '()
        (coll? (first tree)) (cons (tree-map-a f (first tree))
                                   (tree-map-a f (rest tree)))
        :else (cons (f (first tree))
                    (tree-map-a f (rest tree)))))

(defn tree-map-b [f tree]
  (map (fn [item] (if (coll? item)
                    (tree-map-b f item)
                    (f item)))
       tree))
