(ns sicp-mailonline.paragraphs.1-2-5-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-2-5 :refer :all]))

(facts "greatest common divisors"
       (fact "euclid's algorithm"
             (gcd 40 6) => 2))
