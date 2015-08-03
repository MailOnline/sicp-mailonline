(ns sicp-mailonline.exercises.3-1)

(defn make-acc [init]
  (let [sum (atom init)]
    (fn [x]
      (swap! sum #(+ % x)))))
