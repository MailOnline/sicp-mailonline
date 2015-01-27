(ns sicp-mailonline.paragraphs.1-3-2-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.1-3-2 :refer :all]))

(facts "poly func"
       (fact "basic stuff"
             (f-xy 3 4) => 456
             (f-ab1 3 4) => 456
             (f-ab2 3 4) => 456
             (f-let 3 4) => 456))

(facts "important difference between clj and scheme"
       (fact "this is 12 in the book, it is 15 with clj"
             (not (= 12 (fn-bind 2))) => true))
