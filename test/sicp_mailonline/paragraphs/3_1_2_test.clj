(ns sicp-mailonline.paragraphs.3-1-2-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.3-1-2 :refer :all]))

(facts "random number generator"
       (fact "once created it repeats the same sequence"
             (let [rnd1 (make-random 42)
                   rnd2 (make-random 42)]
               (take 3 (repeatedly rnd1)) => (take 3 (repeatedly rnd2)))))
