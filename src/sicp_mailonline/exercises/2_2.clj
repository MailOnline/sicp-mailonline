(ns sicp-mailonline.exercises.2-2)

(defn make-point [x y] [x y])
(defn x-coord [[x y]] x)
(defn y-coord [[x y]] y)

(defn make-segment [p1 p2] [p1 p2])
(defn start-segment [[p1 p2]] p1)
(defn end-segment [[p1 p2]] p2)

(defn length-segment [[x1 y1] [x2 y2]]
  (let [d1 (- x2 x1)
        d2 (- y2 y1)]
    (Math/sqrt (+ (* d1 d1) (* d2 d2)))))

(defmacro s [x1 x2 y1 y2]
  `(make-segment (make-point ~x1 ~x2) (make-point ~y1 ~y2)))

(defn print-point [p] (format "(%s,%s)" (x-coord p) (y-coord p)))

(defn midpoint [s]
  (make-point (/ (- (x-coord (end-segment s)) (x-coord (start-segment s))) 2)
              (/ (- (y-coord (end-segment s)) (y-coord (start-segment s))) 2)))
