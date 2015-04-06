(ns sicp-mailonline.exercises.2-27-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-27 :refer :all]))

(facts "visiting trees"
       (fact "should just echo the tree in output"
             (visit '((1 2) (3 4 (5 6)))) => '((1 2) (3 4 (5 6)))))

(facts "reversing nested lists"
       (fact "it works exactly as reverse for flat lists"
             (deep-reverse (range 4)) => '(3 2 1 0))
       (fact "more insteresting when on nested lists"
             (deep-reverse '((1 2) (3 4))) => '((4 3) (2 1))))
