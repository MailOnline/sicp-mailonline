(ns sicp-mailonline.paragraphs.3-1-1-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.3-1-1 :refer :all]))

(facts "instance of bank accounts"
       (fact "repeating operations"
             (let [acct (make-withdraw 100)]
               (acct 10) => 90
               (acct 10) => 80))
       (fact "different instances are independent"
             ((make-withdraw 100) 50) => 50
             ((make-withdraw 100) 30) => 70))
