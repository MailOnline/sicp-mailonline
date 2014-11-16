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
