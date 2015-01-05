(ns sicp-mailonline.exercises.1-17-test
  (:refer-clojure :exclude [*])
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-17 :as mult]))

(facts "mutliply without *"
       (fact "basic recursive"
             (mult/* 4 3) => 12))

(facts "helpers"
       (fact "halving"
             (mult/halve 4) => 2
             (mult/halve 0) => 0
             (mult/halve 1) => 0
             (mult/halve 3) => 0)
       (fact "doubling"
             (mult/double 0) => 0
             (mult/double 2) => 4))

(facts "mutliply without *"
       (fact "slow iterative *"
             (mult/slow-* 4 3) => 12
             (mult/slow-* 2 3) => 6
             (mult/slow-* 0 3) => 0)
       (fact "fast iterative *"
             (mult/fast-* 6 4) => 24
             (mult/fast-* 2 8) => 16
             (mult/fast-* 1 4) => 4
             (mult/fast-* 8 9) => 72
             (mult/fast-* 2 5) => 10))


