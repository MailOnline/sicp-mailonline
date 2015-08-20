(ns sicp-mailonline.exercises.2-40
  (:require [sicp-mailonline.paragraphs.2-2-1 :refer [s-map]]
            [sicp-mailonline.paragraphs.2-2-3 :refer 
              [s-flatmap enumerate-interval prime-sum? make-pair-sum s-filter]]))

(defn unique-pairs [n]
  (->> (enumerate-interval 2 n)
       (s-flatmap (fn [i]
          (->> (enumerate-interval 1 (dec i))
              (s-map (fn [j] [i j])))))))

(defn prime-sum-pairs [n]
 (->> (unique-pairs n)
      (s-filter prime-sum?)
      (s-map make-pair-sum)))
