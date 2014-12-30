(ns sicp-mailonline.examples.1-3-4
  (:require [sicp-mailonline.examples.1-3-3 :refer [fixed-point]]))

(defn average-damp [f]
  (letfn [(average [a b] (/ (+ a b) 2))]
    (fn [x] (average x (f x)))))

(def ^:private ^:const dx 0.00001)

;; Dg(x) = (g(x + dx) - g(x)) / dx
(defn- deriv [g]
  (fn [x] (/ (- (g (+ x dx)) (g x))
             dx)))

;; f(x) = x - g(x) / Dg(x) where Dg(x) is the derivative of g evaluated at x
(defn- newton-transform [g]
  (fn [x] (- x (/ (g x) ((deriv g) x)))))

(defn newtons-method [g guess]
  (fixed-point (newton-transform g) guess))

(defn sqrt [x]
  (letfn [(square [n] (* n n))]
    (newtons-method (fn [y] (- (square y) x)) 1.0)))
