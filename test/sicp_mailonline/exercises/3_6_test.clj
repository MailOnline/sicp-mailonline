;; Exercise 3.6

(ns sicp-mailonline.exercises.3-6-test
  (:require [sicp-mailonline.exercises.3-6 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise3-6
  (testing "pseudo-random numbers"
    (is (= 100 ((rand :reset) 100)))
    (is (= 1680700 (rand :generate)))
    (is (= 330237515 (rand :generate)))
    (is (= 1204175925 (rand :generate)))

    (is (= 100 ((rand :reset) 100)))
    (is (= 1680700 (rand :generate)))
    (is (= 330237515 (rand :generate)))
    (is (= 1204175925 (rand :generate)))))
