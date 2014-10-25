;; Exercise 1.8
;; Newton's method for cube roots is based on the fact that if y is an
;; approximation to the cube root of x, then a better approximation is
;; given by the value:

;;   (x / (y * y)) + 2y
;;   ------------------
;;           3

;; Use this formula to implement a cube-root procedure analogous to
;; the square-root procedure.

(ns sicp-mailonline.exercises.1-8)

(defn- square [x]
  (* x x))

(defn- good-enough? [previous-guess guess]
  (< (Math/abs (- guess previous-guess))
     (Math/abs (* previous-guess 0.001))))

(defn- improve-guess [guess x]
  (/ (+ (/ x 
           (square guess)) 
        (* 2 guess)) 
     3))

(defn- cube-root-iter [previous-guess guess x]
  (if (good-enough? previous-guess guess)
    guess
    (recur guess 
           (improve-guess guess x) 
           x)))

(defn cube-root [x]
  (if (zero? x)
    0
    (cube-root-iter 0 1.0 x)))
