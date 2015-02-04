(ns sicp-mailonline.core)
; 
; Exercise 1.19
;
;
; Fib(n) =  { 0 if n = 0
;           { 1 if n = 1
;           { Fib(n-1) + Fib(n-2)
;
; Fibonacci series is 0, 1, 1, 2, 3, 5, 8, 13, 21,...
;
; a ← Fib(1) = 1
; b ← Fib(0) = 0
;
; a ← a + b
; b ← a
;
; Special case with p = 0, q = 1 of the 
; general case T(p, q) a family of transformations
;
; a ← bq + aq + ap
; b ← bp + aq
;
; Apply T(p, q) twice
;
; a ← (bp + aq)q + (bq + aq + ap)q + (bq + aq + ap)p
; b ← (bp + aq)p + (bq + aq + ap)q 
;
; a ← bpq + aq^2 + bqq^2 + aq^2 + apq + bqp + aqp + ap^2
; b ← bp^2 + aqp + bq^2 + aq^2 + apq
; 
; a ← b(q^2 + 2qp) + a(2q^2 + pq + pq + p^2 )
; b ← b(p^2 + q^2) + (q^2 + 2pq)a
;
; a ← b(q^2 + 2pq) + a(q^2 +2pq) + a(p^2 + q^2) 
; b ← b(p^2 + q^2) + a(q^2 + 2pq)
;
; So
;   p' = p^2 + q^2
;   q' = q^2 + 2pq
;
;
; Fib(2) = T^2(p, q) = T(p^2 + q^2, q^2 + 2pq)
;
; Fib(4) = T^4(p, q) = T^2(p^2 + q^2, q^2 + 2pq) = T(...,....) 
; 
;

(defn fib-iter [a b p q count]
  (cond (= count 0) b
        (even? count)
          (fib-iter
            a
            b
            (+ (* p p) (* q q))           ; p'
            (+ (* q q) (* 2 p q))         ; q' 
            (/ count 2))
        :else
          (fib-iter   
            (+ (* b q) (* a q) (* a p))   ; new a
            (+ (* b p) (* a q))           ; new b
            p
            q
            (- count 1))))


(defn fibn [n]
  (fib-iter 1 0 0 1 n))















