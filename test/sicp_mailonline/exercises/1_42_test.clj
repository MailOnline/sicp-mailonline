;; Exercise 1.42

(ns sicp-mailonline.exercises.1-42-test
  (:require [sicp-mailonline.exercises.1-42 :refer :all]
            [clojure.test :refer :all]))

(defn- square [x]
  (* x x))

(deftest exercise1-42
  (testing "compose"
    (is (= 49
           ((compose square inc) 6))))

  (testing "Clojure built-in"
    (is (= 49
           ((comp square inc) 6)))))
