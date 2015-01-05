(ns sicp-mailonline.exercises.1-16
  (:require [sicp-mailonline.paragraphs.1-2-4 :as expt]))

(defn iter-fast-expt [b n]
  (if (even? n)
    (if (zero? n) 1
      (loop [acc b counter n]
        (if (= 1 counter)
          acc
          (recur (expt/square acc) (/ counter 2)))))
    (expt/i-expt b n)))
