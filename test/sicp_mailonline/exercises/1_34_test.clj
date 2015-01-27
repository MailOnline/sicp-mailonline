(ns sicp-mailonline.exercises.1-34-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.1-34 :refer :all]))

(facts "recursive lambdas invocations"
       (fact "takes whatever funct and invokes with 2"
             (f (partial + 8)) => 10
             (f (partial str "passed ")) => "passed 2"))
       ; (fact "if invoked with itself, it will try to invoke f passing 2 as a param"
       ;       (f f) => "java.lang.Long cannot be cast to a fn."))
