(ns sicp-mailonline.core)

; Exercise 1.3

(defn square [x]
    (* x x))

(defn sum-of-squares [x y]
    (+ (square x) (square y)))


(defn sum-of-squares-largest [x y z]
    (cond   (and (>= x z) (>= y z)) (sum-of-squares x y)
            (and (>= y x) (>= z x)) (sum-of-squares y z)
            :else (sum-of-squares z x)))


