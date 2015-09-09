(ns sicp-mailonline.exercises.3-9-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-9 :refer :all]))

(with-dbg

  (facts "recursive factorial"
         (fact "basic stuff"
               (factorial 5) => 120))

  (facts "iterative factorial"
         (fact "basic stuff"
               (factorial-iter 5) => 120))

)
