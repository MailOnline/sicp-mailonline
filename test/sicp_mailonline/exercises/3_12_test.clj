(ns sicp-mailonline.exercises.3-12-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.mutable]
            [sicp-mailonline.exercises.3-12 :refer :all])
  (:import [sicp_mailonline.mutable Cons]))

(facts "old append"
       (fact "was working fine and it was immutable"
             (append (range 3) (range 4)) => '(0 1 2 0 1 2 3)))

(facts "a mutable append"
       (let [x (Cons. 'a (Cons. 'b nil))
             y (Cons. 'c (Cons. 'd nil))]
         (fact "first operand is permanently aletered after appending"
               (append! x y) => (Cons. 'a (Cons. 'b (Cons. 'c (Cons. 'd nil))))
               x => (Cons. 'a (Cons. 'b (Cons. 'c (Cons. 'd nil))))
               y => (Cons. 'c (Cons. 'd nil))
               (.cdr x) => (Cons. 'b (Cons. 'c (Cons. 'd nil))))
         (fact "OMG!"
               (let [w (append! x y)]
                 w => x
                 ; don't try! recursive data structure!
                 ; y => (Cons. 'c (Cons. 'd (Cons. 'c (Cons. 'd nil))))
                 ))))
