(ns sicp-mailonline.exercises.2-4)

(defn conz [x y] (fn [m] (m x y)))

(defn car [z] (z (fn [p _] p)))

(defn cdr [z] (z (fn [_ q] q)))
