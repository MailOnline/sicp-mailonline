(ns sicp-mailonline.exercises.1-11-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-11 :refer :all]))

(facts "recursive"
       (fact "< 3"
             (frecur 0) => 0
             (frecur 1) => 1
             (frecur 2) => 2)
       (fact ">= 3"
             (frecur 3) => 4
             (frecur 4) => 11
             (frecur 5) => 25
             (frecur 6) => 59))

(facts "recursive"
       (fact "< 3"
             (fiter 0) => 0
             (fiter 1) => 1
             (fiter 2) => 2)
       (fact ">= 3"
             (fiter 3) => 4
             (fiter 4) => 11
             (fiter 5) => 25
             (fiter 6) => 59))
