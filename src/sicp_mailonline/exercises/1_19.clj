(ns sicp-mailonline.exercises.1-19)

; family of transformations T-pq (for p=0, q=1)
; a = (bq + aq + ap)
; b = (bp + aq)
; now apply the transformation again, considering a = (a + b) and b = (a)
; a = a + b = (a + b) + (a) = 2a + b
; b = a     = (a + b)       = a + b
; the 2nd transformation is expressed in terms of the first,
; we need p=1 and q=1 to preserve what we've found in case we want
; to jump directly of two transformations at once

(defn fib-iter [a b p q n]
  (cond (zero? n)
        b
        (even? n)
        (fib-iter a b 1 1 (/ n 2))
        :else
        (fib-iter (+ (* b q) (* a q) (* a p))
                  (+ (* b p) (* a q))
                  p
                  q
                  (dec n))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))
