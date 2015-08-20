; 
; Exercise 2.20
;
(ns sicp-mailonline.exercises.2-20)

(defn is-even [num]
  ; (println "is-even" num)
  (= (rem num 2) 0))

(defn same-parity [first-arg & nums]
    (let [parity (is-even first-arg)
          iter (fn [n acc] 
                  (if (empty? n)
                    acc
                    (let [e (first n)
                      acc (if (= parity (is-even e)) (cons e acc) acc)]
                      (recur (rest n) acc))))]

        (->> (cons first-arg nil)
             (iter nums)
             (reverse))))

        


