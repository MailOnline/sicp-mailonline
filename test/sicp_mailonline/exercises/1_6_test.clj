(ns sicp-mailonline.exercises.1-6-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-6 :refer :all]))

(facts "brand new if"
       (fact "it works as usual"
             (new-if (= 2 3) 0 5) => 5
             (new-if (= 1 1) 0 5) => 0))

;(facts "square roots newton method with new if"
;       (fact "applicative order hitting hard here, will have to be commented out"
;             (sqrt-iter 1.0 9) => 3.00009155413138))
