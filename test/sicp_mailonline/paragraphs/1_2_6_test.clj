(ns sicp-mailonline.paragraphs.1-2-6-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-2-6 :refer :all]))

(facts "Smallest divisors"
       (fact "basic approach"
             (smallest-divisor 16) => 2
             (smallest-divisor 17) => 17)
       (fact "prime"
             (prime? 17) => true))
