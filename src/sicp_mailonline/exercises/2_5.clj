; 
; Exercise 2.5
;
(ns sicp-mailonline.exercises.2-5)


; a ^ b - integer
(defn pow [a b]
  (defn iter [n acc]
    (if (= n 0)
      acc
      (iter (- n 1) (* acc a))))
  (iter b 1))

(defn mpcon [x y] 
  (* (pow 2 x) (pow 3 y)))

(defn pair-accessor [pair factor]
  (defn iter [n acc]
    (if (= (rem n factor) 0) 
      (iter (quot n factor) (+ acc 1))
      acc))
  (iter pair 0))

(defn mpcar [pair]
  (pair-accessor pair 2))

(defn mpcdr [pair]
  (pair-accessor pair 3))

