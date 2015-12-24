(ns sicp-mailonline.exercises.2-43
	(:require [sicp-mailonline.exercises.2-42 :refer [empty-board adjoin-position row column safe?]]
		 	  [sicp-mailonline.paragraphs.2-2-1 :refer [s-map]]
		 	  [sicp-mailonline.paragraphs.2-2-3 :refer [s-flatmap]]))

; (def comparison-count (atom 0))

; (defn safe? [col positions] ;position list of tuples
;     ; (println (str "safe? " positions))
;     (let [{:keys [:testPos :otherPos]} (group-by #(if (= (column %) col) :testPos :otherPos) 
;                                                  positions)
;           testPos (first testPos)  

;           not-in-check      (fn [cf] (every? #(not (cf testPos %)) otherPos))
;           horizontal-check  (fn [a b] (= (row a) (row b)))
;           diagonal-check    (fn [a b] (= (Math/abs (- (row a) (row b)))
;                                          (Math/abs (- (column a) (column b)))))]
;       ; (println (str "Safe? - column " col " comparisons " (count otherPos)))
;       ; (println otherPos)

;         ; (swap! comparison-count (partial + (count otherPos)))   
;       ; (println (str "Comparison count " @comparison-count)) 
;       (and
;         (not-in-check horizontal-check) 
;         (not-in-check diagonal-check))))

(defn queens [board-size]
  (let [calls (atom 0)]	
	  (letfn [(queen-cols [k] ; returns list of list of tuples
	  	; (swap! calls inc)
	    (if (= k 0)
	      (list empty-board)
        (let [result (->> (queen-cols (dec k))
        	           (mapcat(fn [rest-of-queens] ; rest of queens - list of tuples      
        	              (->> (range 1 (inc board-size))
        	                   (map (fn [new-row]
        	                      (adjoin-position new-row k rest-of-queens)))))) 
        	            (filter (partial safe? k)))]
          ; (println (str "(queen-cols " k ") possible solutions " (count result)))
          ; (println (str "Comparison count " @comparison-count))
          result)))]
    ; (swap! comparison-count (fn [_] 0))
    (let [result (queen-cols board-size)]
    	; (println (str "Calls to queen-cols " @calls))
      ; (count result)
       ; (println (str "Comparison counts: " @comparison-count))
    	result))))

(defn queens-louis [board-size]
  (let [calls (atom {})]	
	  (letfn [(queen-cols [k] ; returns list of list of tuples
      ; (let [key (keyword (str k))]
	  	  ; (swap! calls #(assoc % key (inc (get % key 0)))))
	  	; (println (str "Count " @count "  and k " k))
	    (if (= k 0)
	      (list empty-board)
 		  (->> (range 1 (inc board-size))
	      	   (mapcat (fn [new-row]
	      				(->> (queen-cols (dec k))
	           				 (map (fn [rest-of-queens] ; rest of queens - list of tuples       
	                      	   (adjoin-position new-row k rest-of-queens)))))) 
	           (filter (partial safe? k)))))]

    ; (swap! comparison-count (fn [_] 0))
    (let [result (queen-cols board-size)]
      (println (str "Board size " board-size))
    	; (println (str "Calls to queen-cols: " @calls))
      ; (println (str "Calls to queen-cols total:") (->> @calls (map second) (apply +)))
      ; (count result)
      ; (println (str "Comparison counts: " @comparison-count))
    	result))))



; (println "Original version of queens running for board of 4")
; (time (count (queens 6)))

; (println "Louis's version of queens running for board of 4")
; (time (count (queens-louis 6)))

;
; The problem with swapping the order of the nested mappings is that the
; number of times queen-cols is called changes from linear to exponential
; as it is a recursive call. For the original version, number of calls to 
; queen-cols is O(n). For Louis's version it is O(n^n).
;
; Interesting that when the book was written (late 80's) running queens-louis was
; tooslow forthe 6 queens case yet on my Macbook it runs in 1.4 seconds! But whereas 
; Moore's Law has trumped factorial for a small increase in n, for a slightly larger
; increase in n we would be waiting for the heat death of the universe.  
;
; Slow down roughly 2million K theoretically. Actual ratio is different as time for
; the original version is so fast that other effects (e.g. caching) dominate.


; Actual time is 6mins
