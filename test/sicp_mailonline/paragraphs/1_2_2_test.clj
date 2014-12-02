(ns sicp-mailonline.paragraphs.1-2-2-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-2-2 :refer :all]))

(facts "recursive process fibo"
       (fact "it grows exponentially"
             (recursive-fibo 0) => 0
             (recursive-fibo 1) => 1
             (recursive-fibo 2) => 1
             (recursive-fibo 3) => 2
             (recursive-fibo 4) => 3
             (recursive-fibo 5) => 5
             (recursive-fibo 6) => 8
             ;(recursive-fibo 100000) => stackOverflow
             (recursive-fibo 7) => 13))

(facts "iterative process fibo"
       (fact "it grows linearly instead"
             (iterative-fibo 0) => 0
             (iterative-fibo 1) => 1
             (iterative-fibo 2) => 1
             (iterative-fibo 3) => 2
             (iterative-fibo 4) => 3
             (iterative-fibo 5) => 5
             (iterative-fibo 6) => 8
             (iterative-fibo 7) => 13)
      (fact "so no stack overflow on this one for instance"
             (iterative-fibo 80) => 23416728348467685))
