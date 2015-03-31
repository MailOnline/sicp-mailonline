;; Exercise 2.45
;; Right-split and up-split can be expressed as instances of a general splitting
;; operation.  Define a procedure split with the property that evaluating
;;
;; (define right-split (split beside below))
;; (define up-split (split below beside))
;;
;; produces procedures right-split and up-split with the same behaviour as the
;; ones already defined.

(ns sicp-mailonline.exercises.2-45
  (:require [sicp-mailonline.examples.2-2-4 :refer [beside below]]))

(defn split [op-a op-b]
  (fn [painter n]
    (if (zero? n)
      painter
      (let [smaller ((split op-a op-b) painter (dec n))]
        (op-a painter (op-b smaller smaller))))))

(def right-split (split beside below))

(def up-split (split below beside))
