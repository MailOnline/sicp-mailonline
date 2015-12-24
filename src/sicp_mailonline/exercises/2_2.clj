; 
; Exercise 2.2
;
(ns sicp-mailonline.exercises.2-2)

(defn make-point [x y]
  (list x y))

(defn x-point [point]
  (first point))

(defn y-point [point]
  (first (rest point)))

(defn make-segment [start end]
  (list start end))

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (first (rest segment)))

(defn average [a b]
  (/ (+ a b) 2))

(defn midpoint-segment [segment]
  (make-point
    (average 
      (x-point (start-segment segment)) 
      (x-point (end-segment segment)))
    (average 
      (y-point (start-segment segment)) 
      (y-point (end-segment segment)))))

(defn print-point [p]
  (println "(" (x-point p) "," (y-point p) ")"))

    
