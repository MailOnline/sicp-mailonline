(ns sicp-mailonline.exercises.2-2-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-2 :refer :all]))

(facts "points"
       (fact "creating"
             (make-point 1 2) => [1 2])
       (fact "selectors"
             (x-coord (make-point 3 4)) => 3
             (y-coord (make-point 8 1)) => 1))

(facts "segments"
       (fact "creating"
             (s 0 1 1 0) => [[0 1] [1 0]])
       (fact "selectors"
             (let [segment (s 0 1 1 0)]
               (start-segment segment) => [0 1]
               (end-segment segment) => [1 0])))

(facts "printing"
       (fact "here it is"
             (print-point (make-point 1 2)) => "(1,2)"))

(facts "useful operations on segments"
       (fact "midpoint"
             (let [segment (s 0 0 4 0)]
               (midpoint segment) => [2 0]
               (midpoint (s 0 0 10 10)) => [5,5])))
