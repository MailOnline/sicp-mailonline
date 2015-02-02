(ns sicp-mailonline.exercises.1-35-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-35 :refer :all]))

(facts "searching the golden ratio using avg damping"
       (fact "thats it"
             (golden-ratio) => 1.6180311591702674))
