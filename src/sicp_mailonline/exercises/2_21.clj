; 
; Exercise 2.21
;
(ns sicp-mailonline.exercises.2-21)

(def square #(* % %))

(defn square-list [items]
  (if (empty? items)
      nil
      (cons 
        (square (first items))
        (square-list (rest items)))))


(defn square-list-2 [items]
  (map square items))

