(ns sicp-mailonline.exercises.2-22-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-22 :refer :all]))

(facts "Trying to make an iterative process out of map"
       (fact "first attempt is reversing the results"
             (square-list1 (list 1 2 3 4)) => '(16 9 4 1))
       (fact "reversing the input list is making miracles."
             (square-list2 (list 1 2 3 4)) => '(1 4 9 16)))
