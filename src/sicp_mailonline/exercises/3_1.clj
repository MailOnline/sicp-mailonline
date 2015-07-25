; 
; Exercise 3.1
;
(ns sicp-mailonline.exercises.3-1)

(defn make-accumulator [start-value]
	(let [s (atom start-value)]
		(fn [v] (swap! s #(+ % v)))))
	

(def A (make-accumulator 5))

(println (A 10))

(println (A 10))
