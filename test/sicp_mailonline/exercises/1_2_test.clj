(ns sicp-mailonline.exercises.1-2-test
  (:require [clojure.test :refer :all]))

(deftest prefix
  (testing "transformed into prefix form"
    (is (= (/
             (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
             (* 3 (- 6 2) (- 2 7)))
           -37/150))))
