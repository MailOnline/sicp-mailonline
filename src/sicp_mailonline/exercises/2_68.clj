(ns sicp-mailonline.exercises.2-68
  (:require [sicp-mailonline.paragraphs.2-3-4 :refer :all]))

(defn encode-symbol [s tree]
  (loop [res [] branch tree]
    (cond
      (leaf? branch) res
      (contains? (into #{} (symbols (left-branch branch))) s) (recur (conj res 0) (left-branch branch))
      (contains? (into #{} (symbols (right-branch branch))) s) (recur (conj res 1) (right-branch branch))
      :else (throw (RuntimeException. (format "Couldn't find symbol %s in tree" s))))))

(defn encode [[head & others :as message] tree]
  (if (empty? message)
    (list)
    (concat (encode-symbol head tree) (encode others tree))))
