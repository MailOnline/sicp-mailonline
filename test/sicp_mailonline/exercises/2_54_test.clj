(ns sicp-mailonline.exercises.2-54-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-54 :refer :all]))

(facts "deep equality in lists"
       (fact "corner cases"
             (equal? '() '()) => true
             (equal? nil nil) => true)
       (fact "non empty lists"
             (equal? '(1 2) '(1)) => false
             (equal? '(1 2) '(1 2)) => true))
