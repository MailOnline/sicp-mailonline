; 
; Exercise 3.6
;
(ns sicp-mailonline.exercises.3-6
	(:require [sicp-mailonline.rand :refer :all]))

(def new-rand-2
  (let [x (atom random-init)] 
    (fn [operation] 
    	(condp = operation
    		:generate (rand-make-int (swap! x #(rand-update %)))
    		:reset 	  (fn [seed] (swap! x (fn [_] seed)))))))

