(ns sicp-mailonline.exercises.1-9)

(defn sum-recursive [a b]
  (if (zero? a)
    b
    (inc (sum-recursive (dec a) b))))

(defn sum-iterative [a b]
  (if (zero? a)
    b
    (recur (dec a) (inc b))))

; (f 4 5)
; (inc (f 3 5))
; (inc (inc (f 2 5)))
; (inc (inc (inc (f 1 5))))
; (inc (inc (inc (inc (f 0 5)))))
; (inc (inc (inc (inc 5))))
; (inc (inc (inc 6)))
; (inc (inc 7))
; (inc 8)
; 9

; (f 4 5)
; (f 3 6)
; (f 2 7)
; (f 1 8)
; (f 0 9)
; 9
