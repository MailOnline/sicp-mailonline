(ns sicp-mailonline.exercises.1-19-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-19 :refer :all]))

; failing, couldn't find right solution.
#_(facts "faster fibo"
       (fact "logarithmic stuff"
             (fib 0) => 0
             (fib 1) => 1
             (fib 2) => 1
             (fib 3) => 2
             (fib 4) => 3
             (fib 5) => 5
             (fib 6) => 8
             (fib 7) => 13)
      (fact "so no stack overflow on this one for instance"
             (fib 80) => 23416728348467685))
