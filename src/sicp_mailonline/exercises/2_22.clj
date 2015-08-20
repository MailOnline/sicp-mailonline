; Exercise 2.22
; -------------

; The iteration of the input proceeds from the first element (head) to the tail.
; For a single linked list this is linear O(n). Construction of the results 
; proceeds in the reverse order from tail to head. This is also linear O(n). 
; Therefore the algorithm is O(n) but reverses the order of the list. This can 
; be fixed by reversing the list as the last stage which is also O(n) keeping
; the algorithm O(n) overall.

; The problem with reversing the cons is in Clojure cons nil 3 - does not work at all
; 


(ns sicp-mailonline.exercises.2-22)

(defn square [x] (* x x))

(defn square-list [items]
  (letfn [(iter [things answer]
    (if (empty? things) 
      answer
      (recur 
        (rest things)
        (cons 
          (square (first things))
          answer))))]
  (iter items nil)))

;
; Fixed version
;

(defn square-list [items]
  (letfn [(iter [things answer]
    (if (empty? things) 
      answer
      (recur 
        (rest things)
        (cons 
          (square (first things))
          answer))))]
    (reverse (iter items nil))))



