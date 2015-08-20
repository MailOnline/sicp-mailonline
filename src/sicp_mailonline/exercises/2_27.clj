;
; Exercise 2.27
;
(ns sicp-mailonline.exercises.2-27)

(defn deep-reverse [x]
    (cond 
      (nil? x)          x
      (not (seq? x))    x
      (empty? x)        nil
      :else             (concat (deep-reverse (rest x))
                                (list (deep-reverse (first x))))))
