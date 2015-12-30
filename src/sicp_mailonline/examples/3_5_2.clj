;; 3.5.2 Infinite Streams

(ns sicp-mailonline.examples.3-5-2
  (:require [sicp-mailonline.examples.3-5-1 :refer [cons-stream]]))

(defn integers-starting-from [n]
  (cons-stream n
               (integers-starting-from (inc n))))

(def integers (integers-starting-from 1))
