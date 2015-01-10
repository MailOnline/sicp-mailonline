;; Exercise 1.28

(ns sicp-mailonline.exercises.1-28-test
  (:require [sicp-mailonline.exercises.1-28 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const times 20)

(deftest exercise1-28
  (testing "Prime numbers"
    (are [n] (miller-rabin-prime? n times)
            2
            3
            5
            7
           11
         7879
         7883
         7901
         7907
         7919))

  (testing "Miller-Rabin is not fooled by Carmichael numbers"
    (are [n] (not (miller-rabin-prime? n times))
         561
        1105
        1729
        2465
        2821
        6601)))
