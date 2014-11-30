;; 1.2.6 Example: Testing for Primality

(ns sicp-mailonline.examples.1-2-6)

(defn- square [n]
  (* n n))

(defn- divides? [a b]
  (zero? (rem b a)))

(defn- find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (inc test-divisor))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn- expmod [base exp m]
  (cond (zero? exp) 1
        (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
        :else (rem (* base (expmod base (dec exp) m)) m)))

(defn- fermat-test [n]
  (letfn [(try-it [a]
            (= (expmod a n n) a))]
    (try-it (inc (rand-int (dec n))))))

(defn fast-prime? [n times]
  (cond (zero? times) true
        (fermat-test n) (recur n (dec times))
        :else false))
