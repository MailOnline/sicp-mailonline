; 
; Exercise 3.8
;
(ns sicp-mailonline.exercises.3-8)

(defn make-f [] 
  (let [state (atom 1)]
    (fn [x]
      (swap! state inc)
      (* @state (inc x)))))


