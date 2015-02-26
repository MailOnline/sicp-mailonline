; 
; Exercise 2.4
;

(ns sicp-mailonline.core)

(defn mcons [x y] 
  (fn [m] (m x y)))

(defn mcar [z] 
  (z (fn [p q] p)))

(defn mcdr [z] 
  (z (fn [p q] q)))

