;; Exercise 3.56

(ns sicp-mailonline.exercises.3-56-test
  (:require [sicp-mailonline.examples.3-5-1 :as strm]
            [sicp-mailonline.exercises.3-56 :refer [S]]
            [clojure.test :refer :all]))

;; see https://en.wikipedia.org/wiki/Regular_number
(deftest exercise3-56
  (testing "sequence of Hamming / regular numbers"
    (are [n h] (= h (strm/stream-ref S n))
      0  1
      1  2
      2  3
      3  4
      4  5
      5  6
      6  8
      7  9
      8 10
      9 12
     10 15
     11 16
     12 18
     13 20
     14 24
     15 25
     16 27
     17 30
     18 32
     19 36
     20 40
     21 45
     22 48
     23 50
     24 54
     25 60)))
