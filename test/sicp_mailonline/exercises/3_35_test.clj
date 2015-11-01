;; Exercise 3.35

(ns sicp-mailonline.exercises.3-35-test
  (:require [sicp-mailonline.exercises.3-35 :refer :all]
            [sicp-mailonline.examples.3-3-5.constraints :as con]
            [clojure.test :refer :all]))

(deftest exercise3-35
  (let [n (con/make-connector)
        sqn (con/make-connector)]
    (con/probe "n" n)
    (con/probe "square(n)" sqn)
    (squarer n sqn)

    (testing "n->sqn"
      (con/set-value! n 7 'user)
      (is (= 49 (con/get-value sqn))))

    (con/forget-value! n 'user)

    (testing "sqn->"
      (con/set-value! sqn 64.0 'user)
      (is (= 8.0 (con/get-value n))))))
