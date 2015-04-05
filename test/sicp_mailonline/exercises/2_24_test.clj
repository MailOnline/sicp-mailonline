(ns sicp-mailonline.exercises.2-24-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-24 :refer :all]))

(facts "Reasoning on trees"
       (fact "a tree as the eval loop interpretation"
             (list 1 (list 2 (list 3 4))) => '(1 (2 (3 4)))))
