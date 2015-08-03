(ns sicp-mailonline.exercises.3-1-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-1 :refer :all]))

(facts "accumulator"
       (fact "initial sum is set"
             ((make-acc 10) 0) => 10)
       (fact "like reduce"
             (let [acc (make-acc 0)]
               (last (map acc (range 10))) => (reduce + (range 10)))))
