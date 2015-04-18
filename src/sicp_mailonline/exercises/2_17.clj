; 
; Exercise 2.17
;
(ns sicp-mailonline.core)

(defn last-pair [a]
  (if (= a ())
    ()
    (if (= (rest a) ())
     (first a)
     (last-pair (rest a)))))

    
