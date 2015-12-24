; 
; Exercise 2.4
;

(ns sicp-mailonline.exercises.2-4)

(defn mcons [x y] 
  (fn [m] (m x y)))

(defn mcar [z] 
  (z (fn [p q] p)))

(defn mcdr [z] 
  (z (fn [p q] q)))

