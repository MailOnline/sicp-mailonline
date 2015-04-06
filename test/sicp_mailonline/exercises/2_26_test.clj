(ns sicp-mailonline.exercises.2-26-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-26 :refer :all]))

(facts "list processing operation in Clojure"
       (fact "append is the concat equivalent"
             (concat x y) => (list 1 2 3 4 5 6))
       (fact "cons works the same"
             (cons x y) => (list (list 1 2 3) 4 5 6))
       (fact "list of two lists is a composite list"
             (list x y) => '((1 2 3) (4 5 6))))
