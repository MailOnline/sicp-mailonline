(ns sicp-mailonline.exercises.1-9-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-9 :refer :all]))

(facts "summing numbers by unit increments"
       (fact "decrementing one operand, incrementing final sum"
             (sum-recursive 3 4) => 7
             (sum-recursive 9 4) => 13)
       (fact "decrementing one operand, incrementing the other"
             (sum-iterative 3 4) => 7
             (sum-iterative 9 4) => 13))

