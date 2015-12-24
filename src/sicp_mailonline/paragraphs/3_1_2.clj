;
; Paragraph 3.1.2
;
(ns sicp-mailonline.paragraphs.3-1-2
  (:require [sicp-mailonline.gcd :refer :all]
            [sicp-mailonline.monte-carlo :refer :all]
            [sicp-mailonline.rand :refer :all]))


;
; Version 1 using new-rand and local state
;

(def new-rand
  (let [x (atom random-init)] 
    (fn [] 
      (rand-make-int (swap! x #(rand-update %))))))


(defn cesaro-test []
  (= (gcd (new-rand) (new-rand)) 1))

(defn estimate-pi [trials]
  (Math/sqrt (/ 6 (monte-carlo trials cesaro-test))))

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
  (Math/sqrt (/ 6 (rand-gcd-test trials random-init))))

(println (estimate-pi-2 10000))
