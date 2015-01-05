(ns sicp-mailonline.exercises.1-17
  (:refer-clojure :exclude [* double]))

(defn * [a b]
  (if (zero? b)
    0
    (+ a (* a (dec b)))))

; (* 4 3)
; (+ 4 (* 4 2))
; (+ 4 (+ 4 (* 4 1)))
; (+ 4 (+ 4 (+ 4 (* 4 0))))

(defn halve [x]
  (if (even? x)
    (/ x 2)
    0))

(defn double [x]
  (* 2 x))

(defn slow-* [a b]
  (loop [acc 0 cnt b]
    (if (zero? cnt)
      acc
    (recur (+ acc a) (dec cnt)))))

(defn fast-* [a b]
  (loop [acc a cnt b]
    (if (zero? cnt)
      (halve acc)
    (if (even? cnt)
      (recur (double acc) (halve cnt))
      (slow-* a b)))))
