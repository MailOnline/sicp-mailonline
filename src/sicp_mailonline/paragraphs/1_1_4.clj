(ns sicp-mailonline.paragraphs.1-1-4)

(defn sum-squares
  "Sums n squares"
  [& n]
  (apply + (map #(* % %) n)))

