(ns sicp-mailonline.exercises.2-4-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-4 :refer :all]))

(facts "Exercise 2-4"
       (fact "cons" ((conz 1 2) +) => 3)
       (fact "car" (car (conz 1 2)) => 1)
       (fact "cdr" (cdr (conz 1 2)) => 2))
