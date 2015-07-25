;
; Paragraph 3.1.2
;
(ns sicp-mailonline.paragraphs.3-1-2
  (:require [sicp-mailonline.exercises.2-1 :refer :all]     ; gcd
            [sicp-mailonline.exercises.3-2 :refer :all]))   ; sqrt

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


;
; Version 1 using new-rand and local state
;

(def new-rand
  (let [x (atom random-init)] 
    (fn [] 
      (rand-make-int (swap! x #(rand-update %))))))

(defn monte-carlo [trials experiment]
  (letfn [(iter [trials-remaining trials-passed]
    (cond 
      (= trials-remaining 0) (/ trials-passed trials)
      (experiment) (recur (dec trials-remaining) (inc trials-passed))
      :else (recur (dec trials-remaining) trials-passed)))]
  (iter trials 0)))

(defn cesaro-test []
  (= (gcd (new-rand) (new-rand)) 1))

(defn estimate-pi [trials]
  (sqrt (/ 6 (monte-carlo trials cesaro-test))))

(println (estimate-pi 10000))


;
; Version 2 withoutlocal state
;

(defn rand-gcd-test [trials initial-x]
  (letfn [(iter [trials-remaining trials-passed x]
    (let [x1 (rand-update x)
          x2 (rand-update x1)
          x1-int (rand-make-int x1)
          x2-int (rand-make-int x2)]
      (cond  
        (= trials-remaining 0) (/ trials-passed trials)
        (= (gcd x1-int x2-int) 1) (recur (dec trials-remaining) (inc trials-passed) x2)
        :else (recur (dec trials-remaining) trials-passed x2))))]
  (iter trials 0 initial-x)))      

(defn estimate-pi-2 [trials]
  (sqrt (/ 6 (rand-gcd-test trials random-init))))

(println (estimate-pi-2 10000))
