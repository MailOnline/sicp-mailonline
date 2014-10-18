;; Exercise 1.1
;; Below is a sequence of expressions.
;; What is the result printed by the interpreter in response to each expression?
;; Assume that the sequence is to be evaluated in the order in which it is presented.

(ns sicp-mailonline.exercises.1-1-test
  (:require [clojure.test :refer :all]))

(deftest exercise1-1
  (testing "primitive expressions"
    (is (= 10 
           10))
    (is (= 12 
           (+ 5 3 4)))
    (is (= 8 
           (- 9 1)))
    (is (= 3 
           (/ 6 2)))
    (is (= 6
           (+ (* 2 4)
              (- 4 6)))))

  (testing "names and conditional expressions"
    (let [a 3
          b (+ a 1)]
      (is (= 19
             (+ a b (* a b))))
      (is (= false
             (= a b)))
      (is (= b 
             (if (and (> b a) 
                      (< b (* a b)))
               b
               a)))
      (is (= 16
             (cond (= a 4) 6
                   (= b 4) (+ 6 7 a)
                   :else 25)))
      (is (= 6
             (+ 2 (if (> b a)
                    b
                    a))))
      (is (= 16
             (* (cond (> a b) a
                      (< a b) b
                      :else -1)
                (+ a 1)))))))
