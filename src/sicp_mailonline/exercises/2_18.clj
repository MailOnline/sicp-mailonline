; 
; Exercise 2.18
;
(ns sicp-mailonline.exercises.2-18)

(defn new-reverse [a]
  (defn iter [b acc]
    (if (empty? b)
      acc
      (recur 
        (rest b) 
        (cons (first b) acc))))
  (iter a nil))
