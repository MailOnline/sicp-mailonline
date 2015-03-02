(ns sicp-mailonline.paragraphs.2-1-1
  (:require [sicp-mailonline.paragraphs.1-2-5 :as g]))

(declare make-rat)
(declare numer)
(declare denom)

(defn add-rat [x y] (make-rat (+ (* (numer x) (denom y)) (* (numer y) (denom x))) (* (denom x) (denom y))))
(defn sub-rat [x y] (make-rat (- (* (numer x) (denom y)) (* (numer y) (denom x))) (* (denom x) (denom y))))
(defn mul-rat [x y] (make-rat (* (numer x) (numer y)) (* (denom x) (denom y))))
(defn div-rat [x y] (make-rat (* (numer x) (denom y)) (* (denom x) (numer y))))
(defn equal-rat? [x y] (= (* (numer x) (denom y)) (* (numer y) (denom x))))

(defn base-make-rat [n d] [n d])
(defn numer [[x y]] x)
(defn denom [[x y]] y)

(defn print-rat [x]
  (str (format "%s/%s" (numer x) (denom x))))

(defn make-rat [n d]
  (let [g (g/gcd n d)]
    [(/ n g) (/ d g)]))
