; 
; Exercise 2.1
;
(ns sicp-mailonline.exercises.2-1)

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))
 
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

(defn numer [x]
  (first x))

(defn denom [x]
  (first (rest x)))

(defn print-rat [x]
  (println (numer x) "/" (denom x)))
