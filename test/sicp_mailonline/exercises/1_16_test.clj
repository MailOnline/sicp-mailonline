(ns sicp-mailonline.exercises.1-16-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-16 :refer :all]))

(facts "exponentiation"
       (fact "iterative and fast"
             (iter-fast-expt 10000 0) => 1
             (iter-fast-expt 2 4) => 16
             (iter-fast-expt 3 3) => 27
             (iter-fast-expt 4 4) => 256))
