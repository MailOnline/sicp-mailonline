(ns sicp-mailonline.exercises.3-3-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-3 :refer :all]))

(facts "secure bank"
       (fact "the password must be correct."
             ((make-account 10 "secret") 0 "wrong") => "You little chipmunk.")
       (fact "you need more money"
             ((make-account 10 "secret") 20 "secret") => "No way.")
       (fact "all ok"
             ((make-account 100 "secret") 20 "secret") => 80))
