(ns sicp-mailonline.paragraphs.2-4-complex-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.2-4-complex :refer :all]))

(facts "rectangular form"
       (fact "creating"
             (make-from-real-imag-rectangular 1 2) => [1 2])
       (fact "accessors"
             (real-part-rectangular (make-from-real-imag-rectangular 3 4)) => 3
             (imag-part-rectangular (make-from-real-imag-rectangular 5 6)) => 6)
       (fact "magnitude"
             (magnitude-rectangular (make-from-real-imag-rectangular 7 8)) => 10.63014581273465)
       (fact "angle"
             (angle-rectangular (make-from-real-imag-rectangular 9 10)) => 2.019970331718225))

(facts "polar form"
       (fact "creating"
             (make-from-real-imag-polar 45 90) => [100.62305898749054 -2.185039863261519])
       (fact "accessors"
             (real-part-polar (make-from-real-imag-polar 3 4)) => -2.7428793697750193
             (imag-part-polar (make-from-real-imag-polar 5 6)) => 4.210984902023349)
       (fact "magnitude"
             (magnitude-polar (make-from-real-imag-polar 7 8)) => 10.63014581273465)
       (fact "angle"
             (angle-polar (make-from-real-imag-polar 9 10)) => 2.019970331718225))
