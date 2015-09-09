(ns sicp-mailonline.exercises.3-6-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-6 :refer :all]))

(facts "a better random number generator"
       (fact "it generates when told to do so"
             (let [rnd1 (make-random)
                   rnd2 (make-random)
                   _ (take 3 (repeatedly rnd1))
                   _ (take 3 (repeatedly rnd2))
                   newrnd1 (rnd1 42)
                   newrnd2 (rnd2 42)]
               (take 3 (repeatedly newrnd1)) => (take 3 (repeatedly newrnd2)))))
