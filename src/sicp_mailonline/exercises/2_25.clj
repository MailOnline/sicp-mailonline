; Exercise 2.25

(ns sicp-mailonline.core)

(defn part-1 []
  (first (rest (first (rest (rest
    (list 1 3 (list 5 7) 9)))))))

(defn part-2 []
  (first (first
   (list (list 7)))))

(defn part-3 []
  (first (rest (first (rest (first (rest 
    (first (rest (first (rest (first (rest
      (list 1 (list 2 (list 3 (list 4 (list 5 (list 6 7)))))))))))))))))))



