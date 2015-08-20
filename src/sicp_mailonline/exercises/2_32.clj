;
; Exercise 2.32
;

(ns sicp-mailonline.exercises.2-32)

(defn subsets [s]
  (if (empty? s)
    (list '())
    (let [remainder (subsets (rest s))]
      (concat remainder (map #(cons (first s) %) remainder)))))

; 
; Explanation
;
; Let s be a set with its elements indexed
; Let subset(s, n) - be the set of all subsets of the first n elements of s
; Let s(n) be the nth element of s
;
; Then
; subset(s, n) = subset(s, n-1) ⋃ { {s(n)} ⋃ x : x ∈  subset(s, n-1) }  [1]
; where n > 1
;
; And subset(s, 0) = subsets({}) = { {} }
;
; As [1] expresses the LHS in a simpler form then a recursive function can 
; be used
; 
