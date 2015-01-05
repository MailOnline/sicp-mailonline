(ns sicp-mailonline.paragraphs.1-2-4-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-2-4 :refer :all]))

(facts "exponentiation"
       (fact "recursive"
             (r-expt 10000 0) => 1
             (r-expt 2 4) => 16
             (r-expt 3 3) => 27
             (r-expt 4 4) => 256)
       (fact "iterative"
             (i-expt 10000 0) => 1
             (i-expt 2 4) => 16
             (i-expt 3 3) => 27
             (i-expt 4 4) => 256)
       (fact "fast"
             (f-expt 10000 0) => 1
             (f-expt 2 4) => 16
             (f-expt 3 3) => 27
             (f-expt 4 4) => 256))
