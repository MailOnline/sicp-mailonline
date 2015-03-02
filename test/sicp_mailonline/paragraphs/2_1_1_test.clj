(ns sicp-mailonline.paragraphs.2-1-1-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.2-1-1 :refer :all]))

(facts "Creating rationales"
       (fact "rational numbers as num/denom"
             (base-make-rat 1 2) => [1 2]
             (numer (base-make-rat 1 2)) => 1
             (denom (base-make-rat 1 2)) => 2)
       (fact "printing"
             (print-rat (base-make-rat 3 4)) => "3/4")
       (fact "rational numbers in problem domain"
             (print-rat (add-rat (base-make-rat 1 2) (base-make-rat 1 3))) => "5/6"
             (print-rat (mul-rat (base-make-rat 1 2) (base-make-rat 1 3))) => "1/6"
             (print-rat  (add-rat (base-make-rat 1 3) (base-make-rat 1 3))) => "6/9")
       (fact "better make rat"
             (print-rat (make-rat 3 9)) => "2/3"))
