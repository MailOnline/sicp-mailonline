(ns sicp-mailonline.exercises.3-8-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-8 :refer :all]))

(facts "side effects whoas"
       (fact "order of invocation matters..."
             (let [f (make-f)]
               (+ (f 0) (f 1)) => 0)
             (let [f (make-f)]
               (+* (f 0) (f 1)) => 1)))
