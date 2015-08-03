(ns sicp-mailonline.paragraphs.3-1-2)

(defn rand-update [x]
  "It always return the same random number given the same seed x"
  (Math/abs (.nextInt (java.util.Random. x))))

(defn make-random [init]
  (let [seed (atom init)]
    (fn []
      (swap! seed rand-update)
      @seed)))
