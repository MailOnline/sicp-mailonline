;
; Paragraph 2.1.1
;
(ns sicp-mailonline.paragraphs.2-1-1
  (require [sicp-mailonline.gcd :refer :all]))

(declare make-rat)
(declare numer)
(declare denom)


(defn add-rat [x y]
  (make-rat 
    (+ (* (numer x) (denom y)) (* (numer y) (denom x)))
    (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat 
    (- (* (numer x) (denom y)) (* (numer y) (denom x)))
    (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat
    (* (numer x) (numer y))
    (* (denom x) (denom y))))

(defn div-rat [x y]
  (make-rat
    (* (numer x) (denom y))
    (* (denom x) (numer y))))

(defn equal-rat? [x y]
  (= (* (numer x) (denom y))
     (* (numer y) (denom x))))


(defn make-rat [n d]
  (list n d))

(defn numer [x]
  (first x))

(defn denom [x]
  (first (rest x)))

(defn print-rat [x]
  (println (str (numer x) "/" (denom x))))


;
; Examples
;
(println "Examples - no normalization")

(def one-half (make-rat 1 2))
(print-rat one-half)

(def one-third (make-rat 1 3))
(print-rat one-third)

(print-rat (add-rat one-third one-half))
(print-rat (mul-rat one-half one-third))
(print-rat (add-rat one-third one-third))


;
; Example reducing rationals to canoical form
;

(defn make-rat [n d]
  (let [g (gcd n d)]
    (list (/ n g) (/ d g))))

(println "Examples - with normalization")
(print-rat (add-rat one-third one-third))

(println (equal-rat? (make-rat 1 2) (make-rat 2 4)))
(println (sub-rat one-half one-third))
(println (div-rat one-half one-half))





