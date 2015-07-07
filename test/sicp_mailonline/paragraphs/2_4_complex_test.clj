(ns sicp-mailonline.paragraphs.2-4-complex-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.2-4-complex :refer :all]))

(facts "rectangular form"
       (fact "creating"
             (make-from-real-imag 1 2) => [1 2])
       (fact "accessors"
             (real-part (make-from-real-imag 3 4)) => 3
             (imag-part (make-from-real-imag 5 6)) => 6)
       (fact "magnitude"
             (magnitude (make-from-real-imag 7 8)) => 10.63014581273465)
       (fact "angle"
             (angle (make-from-real-imag 9 10)) => 2.019970331718225))

(facts "polar form"
       (fact "creating"
             (make-from-real-imag2 45 90) => [100.62305898749054 -2.185039863261519])
       (fact "accessors"
             (real-part2 (make-from-real-imag2 3 4)) => -2.7428793697750193
             (imag-part2 (make-from-real-imag2 5 6)) => 4.210984902023349)
       (fact "magnitude"
             (magnitude2 (make-from-real-imag2 7 8)) => 10.63014581273465)
       (fact "angle"
             (angle2 (make-from-real-imag2 9 10)) => 2.019970331718225))
