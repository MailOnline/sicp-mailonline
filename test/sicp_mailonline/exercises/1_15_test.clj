(ns sicp-mailonline.exercises.1-15-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-15 :refer :all]))

(def stack (atom []))

(facts "Exercise 1-15"
       (fact "number of times p is invoked"
             (binding [logger stack]
               (with-out-str (printf "%.2f" (sine 12.15)))) => "-0.40"
             (count @stack) => 5)
       (fact "very slowly indeed, some log(a)"
             (binding [logger stack]
               (with-out-str (printf "%.2f" (sine 3000000000)))) => "-0.63"
             (count @stack) => 27))
