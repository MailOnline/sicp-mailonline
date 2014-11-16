;; 1.2.2 Tree Recursion

(ns sicp-mailonline.examples.1-2-2)

(defn rfib
  "Recursive procedure for computing Fibonacci numbers"
  [n]
  (cond (= n 0) 0
        (= n 1) 1
        :else (+ (rfib (- n 1))
                 (rfib (- n 2)))))
(defn ifib
  "Iterative procedure for computing Fibonacci numbers"
  [n]
  (letfn [(fib-iter [a b count]
            (if (zero? count)
              b
              (fib-iter (+ a b)
                        a
                        (dec count))))]
    (fib-iter 1 0 n)))

(defn- first-denomination [kinds-of-coins]
  (condp = kinds-of-coins
    1  1
    2  5
    3 10
    4 25
    5 50))

(defn- cc [amount kinds-of-coins]
  (cond (zero? amount) 1
        (or (neg? amount) (zero? kinds-of-coins)) 0
        :else (+ (cc amount (dec kinds-of-coins))
                 (cc (- amount (first-denomination kinds-of-coins))
                     kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))
