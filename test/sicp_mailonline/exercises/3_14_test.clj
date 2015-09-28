(ns sicp-mailonline.exercises.3-14-test
  (:refer-clojure :exclude [reverse])
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.mutable]
            [sicp-mailonline.exercises.3-14 :refer :all])
  (:import [sicp_mailonline.mutable Cons]))

(facts "Exercise 3-14"
       (fact "mistery is reverse with mutation"
             (reverse
               (Cons. 'a (Cons. 'b (Cons. 'c (Cons. 'd nil))))) =>
             (Cons. 'd (Cons. 'c (Cons. 'b (Cons. 'a nil))))))
