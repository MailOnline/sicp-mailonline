(ns sicp-mailonline.rand)

;
; Linear congruential random number generator used by Java
; Reimplementation in Clojure as Java version includes shared state making
; the excericse a bit redundant
;
; See http://www.learningclojure.com/2013/02/linear-congruential-random-number.html
;

(defn rand-iterator [a b c]
  (fn[x] (mod (+ (* a x) b) (bit-shift-left 1 c))))

(def random-init 0x5DEECE66DN)

(def rand-update (rand-iterator 0x5DEECE66D 0xB 48))

(defn rand-make-int [x]
  (Math/abs (unchecked-int (bit-shift-right (long x) 16))))

