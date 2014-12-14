;; Exercise 1.32
;; a.  Show that sum and product (exercise 1.31) are both special cases of a
;; still more general notion called accumulate that combines a collection of
;; terms, using the general accumulation function:
;;   (accumulate combiner null-value term a next b)
;; Accumulate takes as arguments the same term and range specifications as sum
;; and product, together with a combiner procedure (of two arguments) that
;; specifies how the current term  is to be combined with the accumulation of
;; preceding terms and a null-value that specifies what base value to use when
;; the terms run out.  Write accumulate and show how sum and product can both be
;; defined as simple terms to accumulate.
;; b.  If your accumulate procedure generates a recursive process, write one
;; that generates an iterative process.  If it generates an iterative process,
;; write one that generates a recursive process.

(ns sicp-mailonline.exercises.1-32)

(defn raccumulate [combiner null-value term next a b]
  (if (> a b)
    null-value
    (combiner (term a)
              (raccumulate combiner null-value term next (next a) b))))

(defn iaccumulate [combiner null-value term next a b]
  (letfn [(iter [value result]
            (if (> value b)
              result
              (recur (next value)
                     (combiner (term value) result))))]
    (iter a null-value)))

(defn make-sum [accumulate term next]
  (partial accumulate + 0 term next))

(defn make-product [accumulate term next]
  (partial accumulate * 1 term next))
