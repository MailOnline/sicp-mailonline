;; Exercise 2.33
;; Fill in the missing expressions to complete the following definitions of some
;; basic list-manipulation operations as accumulations:
;;
;; (define (map p sequence)
;;   (accumulate (lambda (x y) <??>) nil sequence))
;;
;; (define (append seq1 seq2)
;;   (accumulate cons <??> <??>))
;;
;; (define (length sequence)
;;   (accumualte <??> 0 sequence))

(ns sicp-mailonline.exercises.2-33
  (:require [sicp-mailonline.examples.2-2-3 :refer :all]))

(defn map [p sequence]
  (accumulate (fn [x y] (cons (p x) y)) '() sequence))

(defn append [seq1 seq2]
  (accumulate cons seq2 seq1))

(defn length [sequence]
  (accumulate (fn [x y] (inc y)) 0 sequence))
