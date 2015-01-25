;; Exercise 2.2
;; Consider the problem of representing line segments in a plane.  Each segment
;; is represented as a pair of points: a starting point and an ending point.
;; Define a constructor make-segment and selectors start-segment and end-segment
;; that define the representation in terms of points.
;; Furthermore, a point can be represented as a pair of numbers: the x coordinate
;; and the y coordinate.  Accordingly, specify a constructor make-point and
;; selectors x-point and y-point that define this representation.  Finally, using
;; your selectors and constructors, define a procedure midpoint-segment that
;; takes a line segment as argument and returns its midpoint (the point whose
;; coordinates are the average of the coordinates of the endpoints).
;; To try your procedures you'll need a way to print points:
;; (define (print-point p)
;;   (newline)
;;   (display "(")
;;   (display (x-point p))
;;   (display ",")
;;   (display (y-point p))
;;   (display ")"))

(ns sicp-mailonline.exercises.2-2)

(defn make-segment [start-point end-point]
  (vector start-point end-point))

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (second segment))

(defn make-point [x y]
  (vector x y))

(defn x-point [point]
  (first point))

(defn y-point [point]
  (second point))

(defn- average [a b]
  (/ (+ a b)
     2))

(defn midpoint-segment [segment]
  (let [start (start-segment segment)
        end (end-segment segment)]
    (make-point (average (x-point start) (x-point end))
                (average (y-point start) (y-point end)))))

(defn print-point [p]
  (printf "%n(%d,%d)", (x-point p) (y-point p)))
