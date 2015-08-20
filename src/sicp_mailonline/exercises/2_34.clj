(ns sicp-mailonline.exercises.2-34
  (:require [sicp-mailonline.paragraphs.2-2-3 :refer [s-accumulate]]))

(defn horner-eval [x coefficient-sequence]
  (->> coefficient-sequence
       (s-accumulate (fn [this-coeff higher-terms]
                      (+ (* x higher-terms) this-coeff))
                   0)))




