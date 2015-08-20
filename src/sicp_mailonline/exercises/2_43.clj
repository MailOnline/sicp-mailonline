(ns sicp-mailonline.exercises.2-43
	(:require [sicp-mailonline.exercises.2-42 :refer [empty-board adjoin-position row column safe?]]
		 	  [sicp-mailonline.paragraphs.2-2-1 :refer [s-map]]
		 	  [sicp-mailonline.paragraphs.2-2-3 :refer [s-flatmap]]))


(defn queens [board-size]
  (let [count (atom 0)]	
	  (letfn [(queen-cols [k] ; returns list of list of tuples
	  	(swap! count inc)
	    (if (= k 0)
	      (list empty-board)
	      (->> (queen-cols (dec k))
	           (mapcat (fn [rest-of-queens] ; rest of queens - list of tuples      
	              (->> (range 1 (inc board-size))
	                   (map (fn [new-row]
	                      (adjoin-position new-row k rest-of-queens)))))) 
	            (filter (partial safe? k)))))]

    (let [result (queen-cols board-size)]
    	(println (str "Calls to queen-cols " @count))
    	result))))

(defn queens-louis [board-size]
  (let [count (atom 0)]	
	  (letfn [(queen-cols [k] ; returns list of list of tuples
	  	(swap! count inc)
	  	; (println (str "Count " @count "  and k " k))
	    (if (= k 0)
	      (list empty-board)
 		  (->> (range 1 (inc board-size))
	      	   (s-flatmap (fn [new-row]
	      				(->> (queen-cols (dec k))
	           				 (s-map (fn [rest-of-queens] ; rest of queens - list of tuples       
	                      	   (adjoin-position new-row k rest-of-queens)))))) 
	           (filter (partial safe? k)))))]

    (let [result (queen-cols board-size)]
    	(println (str "Calls to queen-cols" @count))
    	result))))



; (println "Original version of queens running for board of 4")
; (time (count (queens 6)))

; (println "Louis's version of queens running for board of 4")
; (time (count (queens-louis 6)))

;
; The problem with swapping the order of the nested mappings is that the
; number of times queen-cols is called changes from linear to exponential
; as it is a recursive call
;
; Interesting that when the book was written (late 80's) running queens-louis was too slow for
; the 6 queens case yet on my Macbook it runs in 1.4 seconds! But increases in processing power
; cannot beat factorial as you increase n. 
;
; Performance is roughly of O(n^n). Predicted time for 8 queens is 6mins. 
; Actual time is 6mins
;
; Slow down roughly 2million K theoretically. Actual ratio is different as time for
; the original version is so fast that other effects (e.g. caching) dominate.



