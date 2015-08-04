(ns sicp-mailonline.exercises.3-7-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.3-7 :refer :all]))

(facts "password protected joint accounts"
       (fact "operations on one affects amount on other"
             (let [acc1 (make-account 100 "pwd1")
                   acc2 (make-joint acc1 "pwd1" "pwd2")
                   tot (acc1 20 "pwd1")]
               (acc2 30 "pwd2") => (- 100 20 30)
               (acc1 10 "pwd1") => (- 100 20 30 10))))
