(ns sicp-mailonline.exercises.2-3-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-3 :refer :all]))

(def a-rectangle (make-rectangle [0 0] [4 0] [4 2] [0 2]))

(facts "rectangles"
       (fact "basics"
             a-rectangle => [[0 0] [4 0] [4 2] [0 2]])
       (fact "selectors"
             (height a-rectangle) => 2.0
             (width a-rectangle) => 4.0))

(facts "operations on rectangles"
       (fact "perimeter"
             (perimeter a-rectangle) => 12.0)
       (fact "area"
             (area a-rectangle) => 8.0))
