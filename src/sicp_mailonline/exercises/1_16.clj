(ns sicp-mailonline.exercises.1-16
  (:require [sicp-mailonline.paragraphs.1-2-4 :as expt]))

(defn iter-fast-expt [b n]
  (if (zero? n) 1
    (loop [acc b counter n]
      (if (= 1 counter)
        acc
        (if (even? n)
          (recur (expt/square acc) (/ counter 2))
          (recur (* acc b) (dec counter)))))))
