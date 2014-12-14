;; Exercise 1.30
;; The sum procedure above generates a linear recursion.  The procedure can be
;; rewritten so that the sum is performed iteratively.  Show how to do this by
;; filling in the missing expressions in the following definition:
;;
;; (define (sum term a next b)
;;   (define (iter a result)
;;     (if (??)
;;       (??)
;;       (iter (??) (??))))
;;   (iter (??) (??)))

(ns sicp-mailonline.exercises.1-30)

(defn sum [term a next b]
  (letfn [(iter [a result]
            (if (> a b)
              result
              (recur (next a)
                     (+ (term a) result))))]
    (iter a 0)))
