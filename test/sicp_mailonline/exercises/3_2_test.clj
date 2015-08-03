(ns sicp-mailonline.exercises.3-2-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-2 :refer :all]))

(facts "making monitored functions"
       (fact "it just behaves exactly as the original"
             ((make-monitored +) 2 2) => 4)
       (fact "now I can ask how many invocations"
             (let [my+ (make-monitored +)
                   _ (dorun (map my+ (range 10)))]
               (my+ 'how-many-calls?) => 10)))
