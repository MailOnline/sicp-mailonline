; 
; Exercise 2.21
;
(ns sicp-mailonline.core)

(defn square [x]
  (* x x))

(defn square-list [items]
  (if (empty? items)
      nil
      (cons 
        (square (first items))
        (square-list (rest items)))))


(defn square-list-2 [items]
  (map square items))

