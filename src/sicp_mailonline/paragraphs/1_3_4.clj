(ns sicp-mailonline.paragraphs.1-3-4
  (:require [sicp-mailonline.paragraphs.1-3-3 :as p]))

(defn square [x] (* x x))
(defn cube [x] (* (square x) x))

(def dx 0.00001)

(defn deriv [g]
  (fn [x] (/ (- (g (+ x dx)) (g x)) dx)))

(defn newton-transform [g]
  (fn [x] (- x (/ (g x) ((deriv g) x)))))

(defn newtons-method [g guess]
  (p/fixed-point (newton-transform g) guess))

(defn sqrt [x]
  (newtons-method (fn [y] (- (square y) x)) 1.0))

(defn fixed-point-of-transform [g transform guess]
  "going generic with all this stuff"
  (p/fixed-point (transform g) guess))

(defn average [f]
  (fn [x] (/ (+ x (f x)) 2)))

(defn sqrt-first [x]
  (fixed-point-of-transform
    (fn [y] (/ x y))
    average
    1.0))

(defn sqrt-second [x]
  (fixed-point-of-transform
    (fn [y] (- (square y) x))
    newton-transform
    1.0))
