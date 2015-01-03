(ns sicp-mailonline.exercises.1-12-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-12 :refer :all]))

(facts "pascal triangle"
       (fact "edges"
             (cell 1 1) => 1
             (cell 2 1) => 1
             (cell 3 1) => 1
             (cell 4 4) => 1
             (cell 100 100) => 1)
       (fact "middle"
             (cell 5 3) => 6
             (= (cell 5 2) (cell 5 4)) => true
             (cell 12 6) => 462))
