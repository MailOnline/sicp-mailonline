;; Exercise 2.32
;; We can represent a set as a list of ditinct elements, and we can represent
;; the set of all subsets of the set as a list of lists.  For example, if the
;; set is (1 2 3), then the set of all subsets is
;;   (() (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3)).
;; Complete the following definition of a procedure that generates the set of
;; subsets of a set and give a clear explanation of why it works:
;;                                        ;
;; (define (subsets s)
;;   (if (null? s)
;;     (list nil)
;;     (let ((rest (subsets (cdr s))))
;;       (append rest (map <??> rest)))))

(ns sicp-mailonline.exercises.2-32
  (:require [sicp-mailonline.examples.2-2-1 :refer [append]]))

(defn subsets [s]
  (if (empty? s)
    (list '())
    (let [rest (subsets (rest s))]
      (append rest (map #(cons (first s) %) rest)))))

;; The subsets of n distinct values, is the subset of n-1 distinct values, plus
;; the additional sets represented by the inclusion of the excluded value to
;; each of those sets.
;;
;; For example: subsets (1 2) -> (() (1) (2) (1 2))
;;   where a. subsets of (1) -> (() (1))
;;         b. include 2 in each set from a. -> ((2) (1 2))
;;         c. combine results of a. and b. -> (() (1) (2) (1 2))
;;
;; subsets (1 2 3) -> (() (1) (2) (3) (1 2) (1 3) (2 3) (1 2 3))
;;   where a. subsets of (1 2) -> (() (1) (2) (1 2))
;;         b. include 3 in each set from a. -> ((3) (1 3) (2 3) (1 2 3))
;;         c. combine results of a. and b. -> (() (1) (2) (1 2) (3) (1 3) (2 3) (1 2 3))
