; 
; Exercise 2.6
;
(ns sicp-mailonline.core)

(defn zero [f]
  (fn [x] x))

(defn one [f]
  (fn [x] (f x)))

(defn two [f]
  (fn [x] (f (f x))))

(defn three [f]
  (fn [x] (f (f (f x)))))

(defn add-1 [n]
  (fn [f]
    (fn [x] (f ((n f) x)))))

(defn add [a b]
  (fn [f]
    (fn [x] ((a f) ((b f) x)))))

