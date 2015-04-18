; Exercise 2.23

(ns sicp-mailonline.core)

(defn for-each [func data]
  (defn iter [d]  
    (if (not (empty? d))
      (do
        (func (first d))
        (recur (rest d)))))

  (iter data))

