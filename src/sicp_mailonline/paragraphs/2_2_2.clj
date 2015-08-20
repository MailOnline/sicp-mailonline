(ns sicp-mailonline.paragraphs.2-2-2
  (:require [sicp-mailonline.paragraphs.2-2-1 :refer [length]]))

;
; 2.2.2 Hierachical structures
; 

(defn count-leaves [x]
  (cond 
    (nil? x)          0 ; (seq? nil) is false       
    (not (seq? x))    1
    (empty? x)        0 ; Only valid on sequences
    :else             (+ (count-leaves (first x))
                        (count-leaves (rest x)))))

(def x (cons (list 1 2) (list 3 4)))

(println (length x))
(println (count-leaves x))

(println (length (list x x)))
(println (count-leaves (list x x)))


;
; Mapping over trees
;

(defn scale-tree [tree factor]
  (cond
    (nil? tree)         nil
    (not (coll? tree))  (* tree factor)
    (empty? tree)       nil
    :else (cons (scale-tree (first tree) factor)
                (scale-tree (rest tree) factor))))

(println (scale-tree (list 1 
                           (list 2 (list 3 4) 5)
                           (list 6 7))
                      10))

(defn scale-tree [tree factor]
  (map (fn [sub-tree]
          (if (coll? sub-tree)
              (scale-tree sub-tree factor)
              (* sub-tree factor)))
        tree))

(println (scale-tree (list 1 
                           (list 2 (list 3 4) 5)
                           (list 6 7))
                      10))
