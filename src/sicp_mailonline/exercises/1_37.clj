;; Exercise 1.37
;; An infinite continued fraction is an expression of the form
;;   f = N1 / (D1 + N2 / (D2 + N3 / (D3 + ... )))
;; As an example, one can show that the infinite continued fraction expansion
;; with the Ni and Di all equal to 1 produces 1/o, where o is the golden-ratio
;; (described in section 1.2.2).  One way to approximate an infinite continued
;; fraction is to truncate the expansion after a given number of terms.  Such
;; a truncation - a so-called k-term finite continued fraction - has the form
;;   N1 / (D1 + N2 / (... + Nk / Dk))
;; Suppose that n and d are procedures of one argument (the term index i) that
;; return Ni and Di of the terms of the continued fraction.  Define a procedure
;; cont-frac such that evaluating (cont-frac n d k) computes the value of the
;; k-term finite continued fraction.  Check your procedure by approximating
;; 1/o (where o is the golden ratio) using
;;   (cont-frac (lambda (i) 1.0)
;;              (lambda (i) 1.0)
;;              k)
;; for successive values of k.
;; How large must you make k in order to get an approximation that is accurate
;; to 4 decimal places?
;; b.  If your cont-frac procedure generates a recursive process, write one that
;; generates an iterative process.  If it generates an iterative process, write
;; one that generates a recursive process.

(ns sicp-mailonline.exercises.1-37)

(defn cont-frac-r [n d k]
  (letfn [(iter [i]
            (if (= i k)
              (/ (n i) (d i))
              (/ (n i) (+ (d i) (iter (inc i))))))]
    (iter 1)))

(defn cont-frac-i [n d k]
  (letfn [(iter [i acc]
            (if (zero? i)
              acc
              (recur (dec i)
                     (/ (n i) (+ (d i) acc)))))]
    (iter (dec k) (/ (n k) (d k)))))

(defn one-over-golden-ratio [f k]
  (f (constantly 1.0)
     (constantly 1.0)
     k))
