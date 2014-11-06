(ns sicp-mailonline.exercises.1-7-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-7 :refer :all]))

(facts "improving guess on large numbers"
       (fact "improve is not able to improve again"
             (let [guess (Integer/MAX_VALUE)
                   x (* (Integer/MAX_VALUE) (Integer/MAX_VALUE))
                   first-guess (improve guess x)]
               (= (improve first-guess x) first-guess) => true)))

(facts "square roots newton method"
       (fact "large numbers"
             (sqrt 11111111111111111111) => 3.333333340756033E9))
