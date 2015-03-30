(ns sicp-mailonline.exercises.2-6-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-6 :refer :all]))

(facts "Exercise 2-6"
       (fact "zero it's a fn of a fn an identity fn"
             ((zero :ignored) :identity) => :identity)
       (fact "it invokes the given function on an argument once"
             (((add-1 zero) :a) {:a 1 :b 2}) => 1
             (((add-1 zero) inc) 0) => 1)
       (fact "trying other numbers"
             (((one) inc) 0) => 1
             (((two) inc) 0) => 2))
