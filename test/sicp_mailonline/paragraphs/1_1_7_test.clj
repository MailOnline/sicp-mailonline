(ns sicp-mailonline.paragraphs.1-1-7-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-1-7 :refer :all]))

(facts "testing if the given guess is good enough"
       (fact "not good enough"
             (good-enough? 1.0 4) => false)
       (fact "good enough"
             (good-enough? 2.00001 4) => true))

(facts "square roots newton method"
       (fact "some guesses"
             (sqrt 9) => 3.00009155413138
             (sqrt (+ 100 37)) => 11.704699917758145
             (sqrt (+ (sqrt 2) (sqrt 3))) => 1.7739279023207892
             (* (sqrt 1000) (sqrt 1000)) => 1000.000369924366))
