(ns sicp-mailonline.exercises.2-5-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-5 :refer :all]))

(facts "extracting the exponent"
       (fact "exponent given the result"
             (exp 2 16) => 4
             (exp 3 81) => 4)
       (fact "fixed base exponents"
             (exp-2 32) => 5
             (exp-3 27) => 3)
       (fact "multiplied exponents"
             (m-exp 864 2 3) => [5 3]))

(facts "pairs as mutliplied exps"
       (fact "constructor" (exp-pair 5 3) => 864.0)
       (fact "selectors"
             (exp-a (exp-pair 5 3)) => 5
             (exp-b (exp-pair 5 3)) => 3))
