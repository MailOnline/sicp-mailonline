(ns sicp-mailonline.exercises.1-29-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-29 :refer :all]))

(facts "simpson single term sum"
       (fact "a few examples"
             (simpson-sum cube 0 1 1) => 4
             (simpson-sum cube 0 1 2) => 2))

; (facts "the final multiplier"
;        (fact "a few examples"
;              (final-mul 0 1 100 300) => 1
;              (final-mul 0 1 1000 3000) => 1))

; (facts "failing Simpson's rule for numerical integration"
;        (fact "integrals"
;              (simpson cube 0 1 2) => 1
;              (simpson cube 0 1 100) => 1
;              (simpson cube 0 1 1000) => 1))
