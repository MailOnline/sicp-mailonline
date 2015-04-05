(ns sicp-mailonline.exercises.2-18-test
  (:refer-clojure :exclude [reverse])
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-18 :refer :all]))

(facts "reverse"
       (fact "reverse of empty list is empty list"
             (reverse '()) => '())
       (fact "reverse of singleton list is the same"
             (reverse '(1)) => '(1))
       (fact "reverse of same element list is same element list"
             (reverse '(1 1 1 1)) => '(1 1 1 1))
       (fact "reverse of simmetrical list is the same"
             (reverse '(4 2 1 2 4)) => '(4 2 1 2 4))
       (fact "reverse of more than one element list"
             (reverse '(1 2)) => '(2 1))
       (fact "more interesting case"
             (reverse '(87 918 82 99)) => '(99 82 918 87))
       (fact "reverse doesn't blow the stack"
             (reverse (range 1000000)) => (clojure.core/reverse (range 1000000))))
