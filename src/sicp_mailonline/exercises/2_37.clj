(ns sicp-mailonline.exercises.2-37
  (:require [sicp-mailonline.paragraphs.2-2-3 :refer [s-accumulate]]
            [sicp-mailonline.exercises.2-36 :refer [s-accumulate-n]]))

; Matrix  (1 2)
;         (3 4)  
; Represented ((1 2) (3 4))
; Basically (row-1 ... row-n)


(defn dot-product [v w]
  (s-accumulate + 0 (map * v w)))

(defn matrix-*-vector [m v]
  (map #(dot-product % v) m))

(defn transpose [mat]
  (s-accumulate-n  (fn [e accum] (cons e accum)) nil mat))

(defn matrix-*-matrix [m n]
  (let [cols (transpose n)]
      (map (fn [e] (matrix-*-vector cols e)) m)))

