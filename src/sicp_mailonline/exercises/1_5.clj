(ns sicp-mailonline.exercises.1-5)

(defn p
  "Recursion/hilarity ensues"
  [] ; (p))
  (throw (Exception. "Infinite recursion.")))

(defn test_
  "Returns y if x is 0"
  [x y]
  (if (= x 0) 0 y))
