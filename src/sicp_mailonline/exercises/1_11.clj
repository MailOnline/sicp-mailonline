(ns sicp-mailonline.exercises.1-11)

(defn f
  "A function f"
  [n]
  (if (< n 3)
    n
    ((f (+ 
          (- n 1)
          
          ))))
