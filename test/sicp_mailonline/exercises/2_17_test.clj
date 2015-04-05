(ns sicp-mailonline.exercises.2-17-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-17 :refer :all]))

(facts "last pair"
       (fact "last of empty is nothing"
             (last-pair '()) => nil)
       (fact "the last element of a singleton list is the element"
             (last-pair (list 1)) => 1)
       (fact "last element of a longer list"
             (last-pair (list 1 23 234 42)) => 42)
       (fact "should not blow up the stack"
             (last-pair (range 10000000)) => 9999999))
