(ns sicp-mailonline.paragraphs.2-2-1
  (:require [sicp-mailonline.abs :refer :all]))

;
; 2.2.1 Representing sequences
;

(def one-through-four (list 1 2 3 4))
(println one-through-four)

(println (first one-through-four))
(println (rest one-through-four))

(println (first (rest one-through-four)))

(println (cons 10 one-through-four))
(println (cons 5 one-through-four))


;
; List operations
;

(defn list-ref [items n]
  (if (= n 0)
    (first items)
    (recur (rest items) (dec n))))

(def squares (list 1 4 9 16 25))
(println (list-ref squares 3))


(defn length [items]
  (if (empty? items)
    0
    (inc (length (rest items)))))

(def odds (list 1 3 5 7))
(println (length odds))

(defn length [items]
  (letfn [(length-iter [a count]
    (if (empty? a)
      count
      (recur (rest a) (inc count))))]
    (length-iter items 0)))
(println (length odds))


(defn append [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1)
          (append (rest list1) list2))))

(println (append squares odds))
(println (append odds squares))


;
; Mapping over lists
;

(defn scale-list [items factor]
  (if (empty? items)
    nil
    (cons (* (first items) factor)
      (scale-list (rest items) factor))))

(println (scale-list (list 1 2 3 4 5) 10))


(defn s-map [proc items]
  (if (empty? items)
    nil
    (cons (proc (first items))
      (s-map proc (rest items)))))

(println (s-map abs (list -10 2.5 -11.6 17)))
(println (s-map #(* % %) '(1 2 3 4)))


(defn scale-list [items factor]
  (s-map #(* % factor) items))

(println (scale-list (list 1 2 3 4 5) 10))




  





