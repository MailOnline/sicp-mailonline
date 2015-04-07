(ns sicp-mailonline.exercises.1-29)

(defn cube [x] (* x x x))

(defn simpson-sum
  ([f a b n]
   (simpson-sum f a b n (fn [n] (if (even? n) 2 4))))
  ([f a b n multip]
    (* (multip n)
       (f (+ a (if (zero? n) 0 (* n (/ (- b a) n))))))))

(defn final-mul [a b n total]
  (* (/ (- b a) (* 3 n)) total))

(defn simpson [f a b n]
  (let [y-0 (simpson-sum f a b 0 (constantly 1))
        y-1 (simpson-sum f a b n (constantly 1))]
    (final-mul a b n
               (+ y-0 y-1
                  (loop [cnt (dec n) sum 0]
                    (if (= 1 cnt)
                      sum
                      (recur (dec cnt) (+ sum (simpson-sum f a b cnt)))))))))

; (defn more-simpson-fail [f a b n]
;   (loop [a 0.0 sum 0 cnt n]
;     (println (format "a %s sum %s" a sum))
;     (if (zero? cnt)
;       sum
;       (let [ss (simpson-sum f (inc a) b cnt)]
;         (println "ss" ss)
;         (recur (inc a) (+ sum ss) (dec cnt))))))
