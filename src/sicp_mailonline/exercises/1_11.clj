;; Exercise 1.11
;; A function f is defined by the rule that f(n) = n if n < 3 and
;; f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n >= 3.

(ns sicp-mailonline.exercises.1-11)

;; Write a procedure that computes f by means of a recursive process.

(defn recur-f [n]
  (if (< n 3)
    n
    (+ (recur-f (- n 1))
       (* 2 (recur-f (- n 2)))
       (* 3 (recur-f (- n 3))))))

;; Write a procedure that computes f by means of an iterative process.

(defn iter-f [n]
  (letfn [(iter [fn fn-1 fn-2 count]
            (if (zero? count)
              fn
              (recur (+ fn (* 2 fn-1) (* 3 fn-2))
                     fn
                     fn-1
                     (dec count))))]
    (if (< n 3)
      n
      (iter 2            ; seed f(n-1) when n=3
            1            ; seed f(n-2) when n=3
            0            ; seed f(n-3) when n=3
            (- n 2)))))  ; iterations required

;; n f(n) f(n-1) f(n-2) f(n-3)
;; 0    0
;; 1    1
;; 2    2
;; 3    4      2      1      0
;; 4   11      4      2      1
;; 5   25     11      4      2
;; 6   59     25     11      4

;; example f(5) : f(n)            f(n-1) f(n-2)     count
;;         iter :    2                 1      0   (5-2)=3
;;        recur :    2+2*1+3*0= 4      2      1         2
;;        recur :    4+2*2+3*1=11      4      2         1
;;        recur :   11+2*4+3*2=25     11      4         0
;;   f(n) => 25
