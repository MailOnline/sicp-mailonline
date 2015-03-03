(ns sicp-mailonline.exercises.2-5)

(defn exp [base total]
  (loop [t total c 2]
    (if (= base (int (/ t base)))
      c
      (recur (/ t base) (inc c)))))

(defn exp-2 [n] (exp 2 n))
(defn exp-3 [n] (exp 3 n))

(defn m-exp [n a b]
  "The idea here is to split by base, either a or b
  until division rest is different from zero."
  (loop [r n c 0]
    (if (zero? (mod r a))
      (recur (/ r a) (inc c))
      [c (exp b r)])))

(defn exp-pair [a b] (* (Math/pow 2 a) (Math/pow 3 b)))
(defn exp-a [p] (first (m-exp p 2 3)))
(defn exp-b [p] (last (m-exp p 2 3)))
