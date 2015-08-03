(ns sicp-mailonline.exercises.3-2)

(defn make-monitored [f]
  (let [cnt (atom 0)]
    (fn [& more]
      (if (= (first more) 'how-many-calls?)
        @cnt
        (do
          (swap! cnt inc)
          (apply f more))))))
