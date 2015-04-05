(ns sicp-mailonline.exercises.2-25-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-25 :refer :all]))

(facts "going zippers"
       (fact "picking 7 from the followings"
             (-> '(1 3 (5 7) 9) rest rest first rest first) => 7
             (-> '((7)) first first) => 7
             (-> '(1 (2 (3 (4 (5 (6 7)))))) rest first rest first rest first rest first rest first rest first) => 7))
