(ns sicp-mailonline.exercises.3-6)

(defn rand-update [x]
  "It always return the same random number given the same seed x"
  (Math/abs (.nextInt (java.util.Random. x))))

(defn make-random [& [reset]]
  (let [seed (atom (or reset (rand-int 10000)))]
    (fn [& [new-seed]]
      (if new-seed
        (make-random new-seed)
        (swap! seed rand-update)))))
