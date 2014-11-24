;; Exercise 1.18
;; Using the results of exercises 1.16 and 1.17, devise a procedure that
;; generates an iterative process for multiplying two integers in terms of
;; adding, doubling, and halving and uses a logarithmic number of steps.

(ns sicp-mailonline.exercises.1-18)

(defn- double [x]
  (+ x x))

(defn- halve [x]
  (/ x 2))

(defn fast-multiply [multiplicand multiplier]
  (letfn [(multiply-iter [a b product]
            (cond
             (zero? b) product
             (even? b) (multiply-iter (double a) (halve b) product)
             (neg? b) (multiply-iter a (inc b) (- product a))
             :else (multiply-iter a (dec b) (+ product a))))]
    (multiply-iter multiplicand multiplier 0)))
