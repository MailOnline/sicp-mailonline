(ns sicp-mailonline.core)

; 1.1.6


(defn abs [x] 
    (cond   (> x 0) x
            (= x 0) 0
            (< x 0) (- 0 x)))

(defn abs2 [x] 
    (cond   (>= x 0) x
            (< x 0) (- 0 x)))

(defn abs3 [x] 
    (cond   (>= x 0) x
            :else (- 0 x)))

