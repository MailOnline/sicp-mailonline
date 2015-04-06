(ns sicp-mailonline.exercises.2-28)

(defn mapreduce [t mapf reducef]
  (cond
    (not (seq? t)) (mapf t)
    (empty? t) t
    :else (reducef (fringe (first t)) (fringe (rest t)))))

(defn fringe [t]
  (mapreduce t list concat))
