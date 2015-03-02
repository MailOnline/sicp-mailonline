(ns sicp-mailonline.exercises.2-1-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.2-1-1 :as common]
            [sicp-mailonline.exercises.2-1 :refer :all]))

(facts "Define a better version of make-rat"
       (fact "positive"
             (common/print-rat (make-rat-negs 1 3)) => "1/3"
             (common/print-rat (make-rat-negs 1 -3)) => "1/3"
             (common/print-rat (make-rat-negs -1 3)) => "-1/3"))
