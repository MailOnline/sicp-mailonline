;; Exercise 2.23

(ns sicp-mailonline.exercises.2-23-test
  (:require [sicp-mailonline.exercises.2-23 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const values (list 57 321 88))

(defn- test-for-each [for-each]
  (for-each println values))

(deftest exercise2-23
  (testing "low-level solution"
    (println "low-level solution")
    (test-for-each for-each-a))
  
  (testing "idiomatic Clojure solution"
    (println "idiomatic Clojure solution")
    (test-for-each for-each-b))
  
  (testing "another idiomatic Clojure solution"
    (println "another idiomatic Clojure solution")
    (test-for-each for-each-c)))
