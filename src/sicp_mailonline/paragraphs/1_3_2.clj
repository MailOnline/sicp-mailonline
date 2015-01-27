(ns sicp-mailonline.paragraphs.1-3-2)

(defn square [x] (* x x))

; the original form presented in the paragraph
(defn f-xy [x y]
  (+ (* x (square (inc (* x y))))
     (* y (- 1 y))
     (* (inc (* x y)) (- 1 y))))

(defn a [x y] (inc (* x y)))
(defn b [y] (- 1 y))

; my rendition of abstracting a,b away, different
; from the paragraph
(defn f-ab1 [x y]
  (+ (* x (square (a x y)))
     (* y (b y))
     (* (a x y) (b y))))

; paragraph ab suggested abstraction, no need for external fns
(defn f-ab2 [x y]
  ((fn [a b]
     (+ (* x (square a))
        (* y b)
        (* a b)))
   (inc (* x y))
   (- 1 y)))

; and now the inversion with let. Let is indeed defyning
; an anonymous inner function invoked with those params.
(defn f-let [x y]
  (let [a (inc (* x y))
        b (- 1 y)]
    (+ (* x (square a))
       (* y b)
       (* a b))))

; in clj, the first binding to x has the precedence to the external x binding
; resulting in all the other let bindings forms knowing about the result
; of the previous bindings.
(defn fn-bind [x]
  (let [x 3
        y (+ x 2)] ; this is (+ 3 2) not (+ ? 2)
    (* x y)))
