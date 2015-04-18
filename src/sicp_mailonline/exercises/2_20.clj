; 
; Exercise 2.20
;
(ns sicp-mailonline.core)

(defn is-even [num]
  ; (println "is-even" num)
  (= (rem num 2) 0))

(defn same-parity [nums &]
  (if (empty? nums)
    '()
    (let [first-arg (first nums)]
      (let [parity (is-even first-arg)]

        (defn iter [n acc]
          (if (empty? n)
            acc
            (let [arg (first n)]
              (if (= parity (is-even arg))
                  (recur (rest n) (cons (first n) acc))
                  (recur (rest n) acc))))))

        (reverse (iter nums '())))))


