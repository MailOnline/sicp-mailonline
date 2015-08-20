(ns sicp-mailonline.paragraphs.2-1-2 
  (require [sicp-mailonline.paragraphs.2-1-1 :refer :all]
           [sicp-mailonline.gcd :refer :all]))

(defn make-rat-2 [n d]
  (cons n (cons d nil)))

(defn numer-2 [x]
  (let [g (gcd (first x) (first (rest x)))]
    (/ (first x) g)))

(defn denom-2 [x]
  (let [g (gcd (first x) (first (rest x)))]
    (/ (first (rest x)) g)))


(alter-var-root #'make-rat (fn [_] make-rat-2))
(alter-var-root #'numer (fn [_] numer-2))
(alter-var-root #'denom (fn [_] denom-2))

(print-rat (add-rat one-third one-third))


