;; Exercise 1.31
;; a.  The sum procedure is only the simplest of a vast number of similar
;; abstractions that can be computed as higher-order procedures.  Write an
;; analogous procedure called product that returns the product of the values
;; of a function at points over a given range.  Show how to define factorial
;; in terms of product.  Also use product to compute approximations to pi
;; using the formula:
;;   pi / 4 = 2/3 * 4/3 * 4/5 * 6/5 * 6/7 * 8/7 ...
;;
;; b. If your product procedure generates a recursive process, write one that
;; generates an iterative process.  If it generates an iterative process, write
;; one that generates a recursive process.

(ns sicp-mailonline.exercises.1-31)

(defn rproduct
  "A product procedure that generates a recursive process."
  [term next a b]
  (if (> a b)
    1
    (* (term a)
       (rproduct term next (next a) b))))

(defn iproduct
  "A product procedure that generates an iterative process."
  [term next a b]
  (letfn [(iter [x result]
            (if (> x b)
              result
              (recur (next x)
                     (* (term x) result))))]
    (iter a 1)))

(defn make-factorial
  "Returns a factorial function defined in terms of product."
  [product]
  (partial product identity inc 1))

(defn make-approx-pi
  "Returns a function that computes an approximation of pi in terms of product,
   where n is an odd integer greater than 3."
  [product n]
  (letfn [(term [denom] (* (/ (dec denom) denom)
                           (/ (inc denom) denom)))
          (next [denom] (if (odd? denom)
                          (+ 2 denom)
                          (inc denom)))]
    (fn [] (* 4 (product term next 3 n)))))
