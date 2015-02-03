(ns sicp-mailonline.paragraphs.1-3-4-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-3-4 :refer :all]))

(facts "derivative of a function"
       (fact "testing out on cube"
             ((deriv cube) 5) => 75.00014999664018))

(facts "square root with newton method in generic form"
       (fact "for example"
             (sqrt 81) => 9.0))

(facts "putting all together with higher abstractions"
       (fact "more square root with avg-damp"
             (sqrt-first 121) => 11.0
             (sqrt-second 121) => 11.000000000000002))
