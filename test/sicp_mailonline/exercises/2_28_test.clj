(ns sicp-mailonline.exercises.2-28-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-28 :refer :all]))

(facts "flatten or fringe"
       (fact "it should just visit nodes and collect them"
             (fringe '((1 2) (3 4))) => '(1 2 3 4)))
