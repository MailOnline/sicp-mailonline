(ns sicp-mailonline.exercises.2-38-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-38 :refer :all]))

(facts "fold left"
       (fact "it depends on operation associativity"
             (fold-left + 0 (range 10)) => (fold-right + 0 (range 10))
             (fold-left / 1 (range 1 4)) => 1/6
             (fold-right / 1 (range 1 4)) => 3/2
             (fold-right list (list) (list 1 2 3)) => '(1 (2 (3 ())))
             (fold-left list (list) (list 1 2 3)) => '(((() 1) 2) 3)))
