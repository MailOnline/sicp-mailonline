(ns sicp-mailonline.paragraphs.1-3-1-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-3-1 :refer :all]))

(facts "summation of a series"
       (fact "integers"
             (sum-integers 1 10) => 55)
       (fact "cubes"
             (sum-cubes 1 10) => 3025)
       (fact "pi/4 leibniz series"
             (* 8 (pi-sum 1 1000)) => 3.139592655589783)
       (fact "integrals"
             (integral cube 0 1 0.01) => 0.24998750000000042
             (integral cube 0 1 0.001) => 0.249999875000001))
