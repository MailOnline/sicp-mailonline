(ns sicp-mailonline.paragraphs.1-3-3-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-3-3 :refer :all]))

(facts "zero of a function between a b"
       (fact "verything fine if the zero splits negatives from positives"
             (search square -1 1) => 0
             (search cube -1 1) => 0)

       (fact "some more complicated fn"
             (search (fn [x] (dec (* 3 (square x)))) -10. 10.) => 0.57708740234375
             ((close-enough? 0.001) (dec (* 3 (square 0.57708740234375))) 0) => true)

       (fact "let's search for pi"
             ((close-enough? 0000.1) (sine 3.14) 0) => true
             (search sine 2.0 4.0) => 2.00048828125) ;; way off

       (fact "another poly"
             (search poly 1.0 2.0) => 1.89306640625))

(facts "half interval method"
       (fact "verything fine if the zero splits negatives from positives"
             ; (half-interval-method square -1 1) => 0
             (half-interval-method sine 2.0 4.0) => 3.14111328125
             (half-interval-method poly 1.0 2.0) => 1.89306640625))

(facts "fixed points"
       (fact "when f(x) equidistant between x/y axis"
             (fixed-point (fn [x] (Math/cos x)) 1.0) => 0.7390822985224024)
       (fact "another example with f(y) = sin(y) + cos(y)"
             (fixed-point (fn [y] (+ (Math/sin y) (Math/cos y))) 1.0) => 1.2587315962971173))

(facts "converging fixed points"
       ; (fact "this square fn doesn't converge and goes into never ending oscillation"
       ;       (sqrt 4) => 2))
  (fact "a better square with average damping"
             (avg-damp-srqt 4) => 2.000000000000002))

