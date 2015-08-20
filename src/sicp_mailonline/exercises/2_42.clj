(ns sicp-mailonline.exercises.2-42)   

(def empty-board nil)

(defn adjoin-position [row column positions]
  (cons [row column] positions))

(defn row [position]
  (first position))

(defn column [position]
  (second position))

(defn safe? [col positions] ;position list of tuples
    (let [{:keys [:testPos :otherPos]} (group-by #(if (= (column %) col) :testPos :otherPos) 
                                                 positions)
          testPos (first testPos)  

          not-in-check      (fn [cf] (every? #(not (cf testPos %)) otherPos))
          horizontal-check  (fn [a b] (= (row a) (row b)))
          diagonal-check    (fn [a b] (= (Math/abs (- (row a) (row b)))
                                         (Math/abs (- (column a) (column b)))))]
      (and
        (not-in-check horizontal-check) 
        (not-in-check diagonal-check))))

(defn queens [board-size]
  (letfn [(queen-cols [k] ; returns list of list of tuples
    (if (= k 0)
      (list empty-board)
      (->> (queen-cols (dec k))
           (mapcat (fn [rest-of-queens] ; rest of queens - list of tuples      
              (->> (range 1 (inc board-size))
                   (map (fn [new-row]
                      (adjoin-position new-row k rest-of-queens)))))) 
            (filter (partial safe? k)))))]

    (queen-cols board-size)))






