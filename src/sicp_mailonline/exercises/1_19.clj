;; Exercise 1.19
;; There is a clever algorithm for computing the Fibonacci numbers in a
;; logarithmic number of steps.  Recall the transformation of the state
;; variables a and b in the fib-iter process of section 1.2.2:
;; a <- a + b and b <- a.
;; Call this transformation T, and observe that applying T over and
;; over again n times, starting with 1 and 0, produces the pair
;; Fib(n+1) and Fib(n).  In other words, the Fibonacci numbers are
;; produced by applying T^n, the nth power of the transformation T,
;; starting with the pair (1,0).  Now consider T to be the special
;; case of p=0 and q=1 in a family of transformations Tpq, where Tpq
;; transforms the pair (a,b) according to:
;; a <- bq + aq + ap and b <- bp + aq.
;; Show that if we apply such a transformation Tpq twice, the effect
;; is the same as using a single transformation Tp'q' of the same
;; form, and compute p' and q' in terms of p and q.  This gives us an
;; explicit way to share these transformations, and thus we can compute
;; T^n using successive squaring, as in the fast-expt procedure.  Put
;; this all together to complete the following procedure, which runs
;; in a logarithmic number of steps:

;; Tpq(a,b)  a <- bq + aq + ap
;;           b <- bp + aq
;;
;; Tpq twice - substitute a and b
;;           a <- (bp + aq)q + (bq + aq + ap)q + (bq + aq + ap)p
;;           a <- bpq + aqq + bqq + aqq + apq + bqp + aqp + app
;;           a <- b(pq + qq + qp) + a(qq + qq + pq + qp + pp)
;;           a <- b(gq + qq + qp) + a(qq + pq + qp) + a(qq + pp)
;;
;;           b <- (bp + aq)p + (bq + aq + ap)q
;;           b <- bpp + aqp + bqq + aqq + apq
;;           b <- b(pp + qq) + a(qp + qq + pq)
;;
;;           p' = pp + qq
;;           q' = qp + qq + pq = 2pq + qq

(defn- fib-iter [a b p q count]
  (cond
   (zero? count) b
   (even? count) (fib-iter a
                           b
                           (+ (* p p) (* q q))    ; p'
                           (+ (* 2 p q) (* q q))  ; q'
                           (/ count 2))
   :else (fib-iter (+ (* b q) (* a q) (* a p))
                   (+ (* b p) (* a q))
                   p
                   q
                   (dec count))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))
