;; 1.2.1 Linear Recursion and Iteration

(ns sicp-mailonline.examples.1-2-1)

(defn rfactorial
  "Defines a linear recursive process for computing the factorial of n."
  [n]
  (if (= n 1)
    1
    (* n (rfactorial (dec n)))))

(defn ifactorial
  "Defines a linear iterative process for computing the factorial of n."
  [n]
  (letfn [(iter [product counter] (if (> counter n)
                                      product
                                      (iter (* counter product)
                                            (inc counter))))]
    (iter 1 1)))
