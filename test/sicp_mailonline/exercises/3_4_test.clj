(ns sicp-mailonline.exercises.3-4-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-4 :refer :all]))

(facts "even more secure bank account"
       (fact "the password must be correct."
             ((make-account 10 "secret") 0 "wrong") => "You have 6 more attempts")
       (fact "you need more money"
             ((make-account 10 "secret") 20 "secret") => "No way.")
       (fact "it call the cops"
             (let [acct (make-account 100 "secret")]
               (last (map #(acct % "wrong") (range 7))) => "calling the cops"))
       (fact "all ok"
             ((make-account 100 "secret") 20 "secret") => 80))
