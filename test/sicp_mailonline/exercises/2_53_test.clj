(ns sicp-mailonline.exercises.2-53-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-53 :refer :all]))

(facts "evaluation"
       (fact "simple examples"
             (list 'a 'b 'c) => '(a b c)
             (list (list 'george)) => '((george))
             (last '((x1 x2) (y1 y2))) => '(y1 y2)
             (first '((x1 x2) (y1 y2))) => '(x1 x2)
             (memq 'red '((red shoes) (blue socks))) => false
             (memq 'red '(red shoes blue socks)) => '(red shoes blue socks)))
