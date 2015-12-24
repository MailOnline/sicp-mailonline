(ns sicp-mailonline.exercises.2-35
  (:require [sicp-mailonline.paragraphs.2-2-3 :refer [s-accumulate]]))

(defn count-leaves[t]
  (->> t
       (map (fn [e]
          (cond 
            (coll? e) (count-leaves e)
            :else (if (nil? e) 0 1)))) 
        (s-accumulate + 0)))


