;
; Exercise 2.33
;

(ns sicp-mailonline.exercises.2-33
  (:require [sicp-mailonline.paragraphs.2-2-3 :refer [s-accumulate]]))

(defn s-map [p sequence]
  (s-accumulate (fn [a b] (cons (p a) b)) nil sequence))

(defn s-append [seq1 seq2]
  (s-accumulate cons seq2 seq1))

(defn s-length [sequence]
  (s-accumulate (fn [_ acc] (inc acc)) 0 sequence))
