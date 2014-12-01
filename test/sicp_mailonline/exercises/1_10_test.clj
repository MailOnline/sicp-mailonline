(ns sicp-mailonline.exercises.1-10-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-10 :refer :all]))

(facts "ackermann"
       (fact "f(n) = A(0,n) is f(x)=2x"
             (A 0 10) => 20
             (A 0 11) => 22
             (A 0 15) => 30
             (A 0 20) => 40)
       (fact "f(n) = A(1,n) is f(x)=2^x"
             (A 1 1) => 2
             (A 1 2) => 4
             (A 1 3) => 8
             (A 1 10) => 1024
             (A 1 20) => 1048576)
       (fact "f(n) = A(2,n) is f(x)=x^4"
             (A 2 1) => 2
             (A 2 2) => 4
             (A 2 3) => 16
             (A 2 4) => 65536))
;             (A 2 5) => :stackOverflow)
