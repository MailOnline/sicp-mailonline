(ns sicp-mailonline.exercises.1-11-test
  (:require [sicp-mailonline.exercises.1-11 :refer :all]
            [clojure.test :refer :all]))

(defn- f-of-n [f]
  (are [n x] (= x (f n))
       0  0
       1  1
       2  2
       3  4
       4 11
       5 25
       6 59))

(deftest exercise1-11
  (testing "compute f by means of a recursive process"
    (let [f recur-f]
      (f-of-n f)))

  (testing "compute f by means of an iterative process"
    (let [f iter-f]
      (f-of-n f))))
