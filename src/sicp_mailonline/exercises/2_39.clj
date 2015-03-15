;; Exercise 2.39
;; Complete the following definitions of reverse (exercise 2.18) in terms of
;; fold-right and fold-left from exercise 2.38:
;;
;; (define (reverse sequence)
;;   (fold-right (lambda (x y) <??>) nil sequence))

;; (define (reverse sequence)
;;   (fold-left (lambda (x y) <??>) nil sequence))

(ns sicp-mailonline.exercises.2-39
  (:require [sicp-mailonline.exercises.2-38 :refer :all]
            [sicp-mailonline.examples.2-2-1 :refer [append]]))

(defn reverse-right [sequence]
  (fold-right (fn [x y] (append y (list x))) '() sequence))

(defn reverse-left [sequence]
  (fold-left (fn [x y] (cons y x)) '() sequence))
