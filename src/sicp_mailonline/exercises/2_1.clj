; 
; Exercise 2.1
;
(ns sicp-mailonline.exercises.2-1
  (:require [sicp-mailonline.paragraphs.2-1-1 :refer [numer denom]]
            [sicp-mailonline.gcd :refer :all]))
 
(defn abs [x]
  (if (< x 0)
    (- 0 x)
    x))

(defn make-rat [n d]
  (defn pair [x y]
    (cons x (cons y nil)))

  (let  [g (gcd n d)  
         numer (abs (/ n g))
         denom (abs (/ d g))]
          
    (cond 
      (and (>= n 0) (>= d 0)) (pair numer denom)
      (and (< n 0) (< d 0))   (pair numer denom)
      :else                   (pair (- 0 numer) denom))))



