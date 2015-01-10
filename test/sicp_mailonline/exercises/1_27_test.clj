;; Exercise 1.27

(ns sicp-mailonline.exercises.1-27-test
  (:require [sicp-mailonline.exercises.1-27 :refer [fermat-prime?]]
            [sicp-mailonline.examples.1-2-6 :refer [prime?]]
            [clojure.test :refer :all]))

;; Numbers that fool the Fermat test are called Carmichael numbers.
;; The smallest few are 561, 1105, 1729, 2465, 2821, and 6601.

(deftest exercise1-27
  (testing "Carmichael numbers pass the Fermat test"
    (are [n] (fermat-prime? n)
         561
        1105
        1729
        2465
        2821
        6601))

  (testing "but Carmichael numbers are not actually prime"
    (are [n] (not (prime? n))
         561
        1105
        1729
        2465
        2821
        6601)))
