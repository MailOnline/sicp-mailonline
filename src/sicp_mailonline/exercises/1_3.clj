;; Exercise 1.3
;; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(ns sicp-mailonline.exercises.1-3)

(defn- square [x]
  (* x x))

(defn- sum-squares [x y]
  (+ (square x)
     (square y)))

(defn- largest [x y]
  (if (> x y) x y))

;; a solution using only what SICP has demonstrated thus far
(defn sum-squares-of-two-largest-a [x y z]
  (if (= x (largest x y))
    (sum-squares x (largest y z))
    (sum-squares y (largest x z))))

;; a solution using more idiomatic Clojure
;; uses the seq abstraction and core library routines such as sort
(defn sum-squares-of-two-largest-b [x y z]
  (let [largest-two (take 2 (sort > (vector x y z)))]
    (sum-squares (first largest-two) 
                 (last largest-two))))
