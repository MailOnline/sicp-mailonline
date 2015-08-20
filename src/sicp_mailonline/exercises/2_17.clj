; 
; Exercise 2.17
;
(ns sicp-mailonline.exercises.2-17)

(defn last-pair [a]
  (if (empty? a)
    nil
    (if (empty? (rest a))
     (first a)
     (recur (rest a)))))

    
