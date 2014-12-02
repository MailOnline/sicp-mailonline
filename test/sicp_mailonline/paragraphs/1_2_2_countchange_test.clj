(ns sicp-mailonline.paragraphs.1-2-2-countchange-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-2-2-countchange :refer :all]))

(facts "dollar change"
       (fact "recursive implementation"
             (count-change 100) => 292))
