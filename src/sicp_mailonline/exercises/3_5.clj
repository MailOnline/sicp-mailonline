; 
; Exercise 3.5
;
(ns sicp-mailonline.exercises.3-5
	(:require [sicp-mailonline.monte-carlo :refer :all]))

(defn random-in-range [low high]
	(let [rand-range (- high low)]
		(+ low (rand rand-range))))

(defn estimate-integral [P x1 x2 y1 y2 trials]
	(letfn [(experiment [] 
		(let [x (random-in-range x1 x2)
			  y	(random-in-range y1 y2)] 
			  (P x y)))]

		(let [ratio (monte-carlo trials experiment)]
			(* (- x2 x1) (- y2 y1) ratio 1.0))))

(defn square [x]
	(Math/pow x 2))

(defn make-circle [radius]
	(fn [x y] 
		(<= (+ (square x) (square y)) (square radius))))
