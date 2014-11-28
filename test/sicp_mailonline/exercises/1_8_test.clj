(ns sicp-mailonline.exercises.1-8-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-8 :refer :all]))

(fact "checking a guess is good enough"
      (fact "expecting to be in the radius of epsilon"
             (good-enough? 3.0000000001 27) => truthy))

(facts "improving guess on large numbers"
       (fact "improve is not able to improve again"
             (good-enough? (cube-root 27) 27) => truthy))
