;; Exercise 2.7
;; Alyssa's program is incomplete because she has not specified the
;; implementation of the interval abstraction.  Here is a definition of the
;; interval constructor:
;;
;;  (define (make-interval a b) (cons a b))
;;
;; Define selectors upper-bound and lower-bound to complete the implementation.

(ns sicp-mailonline.exercises.2-7)

(defn make-interval [a b]
  (vector a b))

(defn lower-bound [interval]
  (first interval))

(defn upper-bound [interval]
  (second interval))


;; Example 2.1.4: Interval Arithmetic

(defn add-interval [x y]
  (make-interval (+ (lower-bound x) (lower-bound y))
                 (+ (upper-bound x) (upper-bound y))))

(defn mul-interval [x y]
  (let [p1 (* (lower-bound x) (lower-bound y))
        p2 (* (lower-bound x) (upper-bound y))
        p3 (* (upper-bound x) (lower-bound y))
        p4 (* (upper-bound x) (upper-bound y))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval [x y]
  (mul-interval x
                (make-interval (/ 1M (upper-bound y))
                               (/ 1M (lower-bound y)))))
