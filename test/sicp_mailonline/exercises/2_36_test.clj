;; Exercise 2.36

(ns sicp-mailonline.exercises.2-36-test
  (:require [sicp-mailonline.exercises.2-36 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const s '((1 2 3) (4 5 6) (7 8 9) (10 11 12)))

(deftest exercise2-36
  (testing "accumulate-n"
    (is (= '(22 26 30)
           (accumulate-n + 0 s)))))
