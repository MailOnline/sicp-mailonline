(ns sicp-mailonline.exercises.2-19-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-19 :refer :all]))

(facts "count change with different currencies"
       (fact "original example works as before"
             (cc 100 us-coins) => 292)
       (fact "but now we have uk coins as well"
             (cc 100 uk-coins) => 4563))
