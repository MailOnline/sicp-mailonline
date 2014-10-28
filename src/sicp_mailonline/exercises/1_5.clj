(ns sicp-mailonline.exercises.1-5)

(defn p []
  "Infinite self invocation"
  (p))

(defn test-lazy [x y]
  (if (= x 0) 0 y))

; normal-order expansion
; (test 0 (p))
; (if (= 0 0) 0 (p))
; => 0
