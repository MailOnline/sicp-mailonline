(ns sicp-mailonline.exercises.3-14
  (:refer-clojure :exclude [reverse]))

(defn reverse [x]
  (loop [x x y nil]
    (if (nil? x)
      y
      (let [temp (.cdr x)]
        (.setcdr x y)
        (recur temp x)))))
