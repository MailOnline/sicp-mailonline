(ns sicp-mailonline.paragraphs.1-2-1-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-2-1 :refer :all]))

(facts "basic factorial"
       (fact "recursive process"
             (!r -1) => 0
             (!r 0) => 0
             (!r 1) => 1
             (!r 2) => 2)
       (fact "iterative process"
             (!i -1) => 0
             (!i 0) => 0
             (!i 1) => 1
             (!i 2) => 2))
