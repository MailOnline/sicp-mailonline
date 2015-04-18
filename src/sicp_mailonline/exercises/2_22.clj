; Exercise 2.22
; -------------

; The iteration of the input proceeds from the first element (head) to the tail.
; For a single linked list this is linear O(n). Construction of the results 
; proceeds in the reverse order from tail to head. This is also linear O(n). 
; Therefore the algorithm is O(n) but reverses the order of the list. This can 
; be fixed by reversing the list as the last stage which is also O(n) keeping
; the alogorithm O(n) overall.


(ns sicp-mailonline.core)

(defn square [x]
  (* x x))

(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things) 
      answer
      (iter 
        (rest things)
        (cons 
          answer
          (square (first things))))))

  (iter items nil))


; The problem is that if the first argument to cons is a list then a cons cell
; is created containing a list. This creates a structure of nested lists.
;
; e.g. for (1 2 3) =>  ((1 4) 9) and not (1 4 9)
; 


