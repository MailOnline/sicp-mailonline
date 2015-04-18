; 
; Exercise 2.18
;
(ns sicp-mailonline.core)

(defn new-reverse [a]
  (defn iter [b acc]
    (if 
      (= b ())
      acc
      (recur 
        (rest b) 
        (cons (first b) acc))))
  (iter a ()))
