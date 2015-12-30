;; Exercise 3.54
;; Define a procedure mul-streams, analogous to add-streams, that produces the
;; elementwise product of its two input streams.  Use this together with the
;; stream of integers to complete the following definition of the stream whose
;; nth element (counting from 0) is n+1 factorial:
;;
;; (define factorials (cons-stream 1 (mul-streams <??> <??>)))

(ns sicp-mailonline.exercises.3-54
  (:require [sicp-mailonline.examples.3-5-1 :refer [cons-stream]]
            [sicp-mailonline.exercises.3-50 :refer [stream-map]]))

(defn mul-streams [s1 s2]
  (stream-map * s1 s2))

(defn integers-starting-from [n]
  (cons-stream n
               (integers-starting-from (inc n))))

(def integers (integers-starting-from 1))
(def factorials (cons-stream 1
                             (mul-streams integers factorials)))
