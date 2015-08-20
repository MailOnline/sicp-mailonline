(ns sicp-mailonline.paragraphs.2-1-3)

(defn cons-2 [x y]
  (letfn [(dispatch [m]
    (cond 
      (= m 0) x
      (= m 1) y
      :else { :error "Argument not 0 or 1: CONS" :value m }))]
    dispatch)) 

(defn car [z] (z 0))
(defn cdr [z] (z 1))

(println (car (cons-2 2 3)))
(println (cdr (cons-2 2 3)))



