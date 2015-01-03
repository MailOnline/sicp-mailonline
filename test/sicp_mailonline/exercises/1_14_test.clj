(ns sicp-mailonline.exercises.1-14-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-14 :refer :all]))

(facts "Exercise 1-14"
       (fact "change for 11"
             (let [logger (atom [])]
               (count-change 11 logger) => 4
               (count @logger) => 55
               (last (last (sort-by last (frequencies @logger)))) => 4))
       (fact "change for 22"
             (let [logger (atom [])]
               (count-change 22 logger) => 9
               (count @logger) => 195
               (last (last (sort-by last (frequencies @logger)))) => 9))
       (fact "change for 33"
             (let [logger (atom [])]
               (count-change 33 logger) => 18
               (count @logger) => 511
               (last (last (sort-by last (frequencies @logger)))) => 18))
       (fact "change for 44"
             (let [logger (atom [])]
               (count-change 44 logger) => 31
               (count @logger) => 1101
               (last (last (sort-by last (frequencies @logger)))) => 31)))

; number of steps 55, 195, 511, 1101 with increment ratios:
; 0.282051282051282
; 0.38160469667319
; 0.464123524069028
; so empirically exponential
