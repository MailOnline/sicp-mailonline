(ns sicp-mailonline.exercises.1-1)

(def expressions
  [
    "10"
    "(+ 5 3 4)"
    "(- 9 1)"
    "(+ (* 2 4) (- 4 6))"
    "(def a 3)"
    "(def b (+ a 1))"
    "(+ a b (* a b))"
    "(= a b)"
    "(if (and (> b a) (< b (* a b))) b a)"
    "(cond (= a 4) 6
          (= b 4) (+ 6 7 a)
          :else 25)"
    "(+ 2 (if (> b a) b a))"
    "(* (cond (> a b) a
             (< a b) b
             :else -1)
       (+ a 1))"
   ])

(defn expression-output
  "Returns the output from running the specified expression as a string"
  [index]
  (str (eval (read-string (expressions index)))))
