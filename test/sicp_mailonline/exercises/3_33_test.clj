;; Exercise 3.33

(ns sicp-mailonline.exercises.3-33-test
  (:require [sicp-mailonline.exercises.3-33 :refer :all]
            [sicp-mailonline.examples.3-3-5.constraints :as con]
            [clojure.test :refer :all]))

(deftest exercise3-33
  (let [a (con/make-connector)
        b (con/make-connector)
        c (con/make-connector)]
    (con/probe "a" a)
    (con/probe "b" b)
    (con/probe "c" c)
    (averager a b c)

    (testing "c"
      (con/set-value! a 6 'user)
      (con/set-value! b 22 'user)
      (is (= 14 (con/get-value c))))

    (con/forget-value! a 'user)
    (con/forget-value! b 'user)
    
    (testing "a"
      (con/set-value! b 18 'user)
      (con/set-value! c 14 'user)
      (is (= 10 (con/get-value a))))

    (con/forget-value! b 'user)
    (con/forget-value! c 'user)

    (testing "b"
      (con/set-value! a 2 'user)
      (con/set-value! c 14 'user)
      (is (= 26 (con/get-value b))))))
