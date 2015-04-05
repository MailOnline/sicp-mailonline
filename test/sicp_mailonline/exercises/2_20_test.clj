(ns sicp-mailonline.exercises.2-20-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-20 :refer :all]))

(facts "same parity as the first argument"
       (fact "quick tests"
             (same-parity 1 2 3 4 5 6 7) => '(1 3 5 7)
             (same-parity 2 3 4 5 6 7) => '(2 4 6)))
