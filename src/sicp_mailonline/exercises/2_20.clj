(ns sicp-mailonline.exercises.2-20)

(defn is-same-parity? [x y]
  (= (odd? x) (odd? y)))

(defn same-parity [probe & others]
  (loop [res (list probe)
         more others]
    (if (empty? more)
      (reverse res)
      (if (is-same-parity? probe (first more))
        (recur (cons (first more) res) (rest more))
        (recur res (rest more))))))
