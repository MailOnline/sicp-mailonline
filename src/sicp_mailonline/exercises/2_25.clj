; Exercise 2.25

(ns sicp-mailonline.exercises.2-25)

(defn part-1 []
  (first (rest (first (rest (rest
    '(1 3 (5 7) 9)))))))

(defn part-2 []
  (first (first
    '((7)))))

(defn part-3 []
  (first (rest (first (rest (first (rest 
    (first (rest (first (rest (first (rest
      '(1 (2 (3 (4 (5 (6 7)))))))))))))))))))


