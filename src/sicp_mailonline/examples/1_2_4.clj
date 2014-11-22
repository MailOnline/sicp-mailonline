(ns sicp-mailonline.examples.1-2-4)

;; b^0 = 1, b^n = b * b^(n-1)
(defn rexpt
  "Computes b^n via a recursive definition."
  [b n]
  (if (zero? n)
    1
    (* b (rexpt b (dec n)))))

(defn iexpt
  "Computes b^n via linear iteration"
  [b n]
  (letfn [(expt-iter [counter product]
            (if (zero? counter)
              product
              (expt-iter (dec counter) (* b product))))]
    (expt-iter n 1)))

(defn- square [x]
  (* x x))

;; b^n = (b^(n/2))^2 if n is even
;; b^n = b * b(n-1) if n is odd
(defn fast-expt
  "Uses successive squaring to compute b^n"
  [b n]
  (cond
   (zero? n) 1
   (even? n) (square (fast-expt b (/ n 2)))
   :else (* b (fast-expt b (dec n)))))
