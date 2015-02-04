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


;
; Example using matrices
;
; Fib(n) can be calculated by using this
; transformation 
;
; (a)   (1  1)^n (a)
; ( ) ← (    )   ( )
; (b)   (1  0)   (b) 
;
;
; Taking a matrix approach, you would normally use 
; a math library that defines matrix operations. 
; For simplicity, I have defined the basic matrix
; operations for 2 x 2 matrices

(defn dot [x y]
  (+  (* (get x 0) (get y 0))
      (* (get x 1) (get y 1))))

(defn mat-mult [x y]
  ; Matrixes are represented as vectors of 4 elements
  ; [0 1 2 3] laid out
  ;  (0 1)
  ;  (2 3) 
  [
    (dot [(get x 0) (get x 1)] [(get y 0) (get y 2)])
    (dot [(get x 0) (get x 1)] [(get y 1) (get y 3)])
    (dot [(get x 2) (get x 3)] [(get y 0) (get y 2)])
    (dot [(get x 2) (get x 3)] [(get y 1) (get y 3)])
  ])

(defn mat-apply [matrix vec]
  [
    (dot [(get matrix 0) (get matrix 1)] vec)
    (dot [(get matrix 2) (get matrix 3)] vec)
  ])

(defn square [a]
  (mat-mult a a))

(defn mat-power [matrix n]
  (defn iter [inner-matrix acc count]
    (cond   (= count 0) 
              acc
            (even? count)
              (iter (square inner-matrix) acc (/ count 2))
            :else  
              (iter inner-matrix (mat-mult inner-matrix acc) (- count 1))))

  (iter matrix [1 0 0 1] n))


; This is the new fibonaccci function
(defn fibn-mat [n]
    (get (mat-apply (mat-power [1 1 1 0] n) [1 0]) 1))



