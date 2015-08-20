(ns sicp-mailonline.exercises.2-41)

(defn unique-triples [n]
  (let [n+1 (inc n)]
    (->> (range 1 n+1) (mapcat (fn [i]
            (->> (range 1 n+1) (mapcat (fn [j]  
               (->> (range 1 n+1) (map (fn [k]
                  [i j k])))))))))))  

(defn triples-less-or-equal [n s]
  (->>  (unique-triples n) 
        (filter (fn [[i j k]] (= (+ i j k) s)))))
