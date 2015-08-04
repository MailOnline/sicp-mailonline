(ns sicp-mailonline.exercises.3-8)

(defmacro +* [a b]
  `(+ ~b ~a))

(defn make-f []
  (let [prod (atom 1)]
    (fn [x]
      (swap! prod #(* x %)))))
