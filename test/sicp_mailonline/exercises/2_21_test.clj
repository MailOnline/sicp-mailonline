(ns sicp-mailonline.exercises.2-21-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-21 :refer :all]))

(facts "squaring elements of a list"
       (fact "same as the exercise example"
             (square-list (list 1 2 3 4)) => '(1 4 9 16)
             (square-list-map (list 1 2 3 4)) => '(1 4 9 16)))
