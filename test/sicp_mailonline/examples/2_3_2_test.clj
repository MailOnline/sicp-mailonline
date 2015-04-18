;; Example 2.3.2

(ns sicp-mailonline.examples.2-3-2-test
  (:require [sicp-mailonline.examples.2-3-2 :refer :all]
            [clojure.test :refer :all]))

(deftest example2-3-2
  (testing "symbolic differentitaion"
    (is (= 1
           (deriv '(+ x 3) 'x)))

    (is (= 'y
           (deriv '(* x y) 'x)))

    (is (= '(+ (* x y) (* y (+ x 3)))
           (deriv '(* (* x y) (+ x 3)) 'x)))))
