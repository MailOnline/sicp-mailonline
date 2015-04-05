(ns sicp-mailonline.exercises.2-21)

(defn square-list [items]
  (if (empty? items)
    items
    (cons
      (* (first items) (first items))
      (square-list (rest items)))))

(defn square-list-map [items]
  (map #(* % %) items))
