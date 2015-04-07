(ns sicp-mailonline.exercises.2-23-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.exercises.2-23 :refer :all]))

(facts "implementing for-each, a doseq equivalent"
       (fact "printing with newlines"
             (let [a (atom [])]
               (for-each #(swap! a conj %) '(57 321 88)) => nil
               @a => [57 321 88])))
