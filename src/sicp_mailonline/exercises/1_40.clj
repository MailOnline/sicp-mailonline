;; Exercise 1.40
;; Define a procedure cubic that can be used together with the newtons-method
;; procedure in expressions of the form
;;   (newtons-method (cubic a b c) 1)
;; to approximate zeros of the cubic x^3 + ax^2 + bx + c.

(ns sicp-mailonline.exercises.1-40)

(defn cubic [a b c]
  (letfn [(cube [n] (* n n n))
          (square [n] (* n n))]    
    (fn [x] (+ (cube x)
               (* a (square x))
               (* b x)
               c))))
