(ns sicp-mailonline.exercises.2-28)

(defn mapreduce [t mapf reducef]
  (cond
    (not (seq? t)) (mapf t)
    (empty? t) t
    :else (reducef (mapreduce (first t) mapf reducef) (mapreduce (rest t) mapf reducef))))

(defn fringe [t]
  (mapreduce t list concat))
