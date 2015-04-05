(ns sicp-mailonline.exercises.2-23-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-23 :refer :all]))

(facts "implementing for-each, a doseq equivalent"
       (fact "printing with newlines"
             (for-each #(do (println) (print %)) '(57 321 88)) => nil))
