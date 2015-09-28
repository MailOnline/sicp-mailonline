(ns sicp-mailonline.exercises.3-13-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.mutable]
            [sicp-mailonline.exercises.3-13 :refer :all])
  (:import [sicp_mailonline.mutable Cons]))

(facts "Funny cycles with mutable structures"
       (fact "don't try this at home"
             "bang" => "bang"
             ; (make-cycle (Cons. 'a (Cons. 'b (Cons. 'c nil)))) => "bang"
             ))
