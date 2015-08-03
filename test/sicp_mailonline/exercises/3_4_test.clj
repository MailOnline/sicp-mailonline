;; Exercise 3.4

(ns sicp-mailonline.exercises.3-4-test
  (:require [sicp-mailonline.exercises.3-4 :refer :all]
            [clojure.test :refer :all]))

(def ^:private count-cops-called (atom 0))

(defn- call-cops []
  (swap! count-cops-called inc))

(defn- fixture [f]
  (reset! count-cops-called 0)
  (f))

(use-fixtures :each fixture)

(deftest correct-password
  (let [acc (make-account 100 'secret-password call-cops)]
    (is (= 60 ((acc 'secret-password :withdraw) 40)))
    (is (= 70 ((acc 'secret-password :deposit) 10)))))

(deftest incorrect-password
  (let [acc (make-account 100 'secret-password call-cops)]
    (is (= "Incorrect password" ((acc 'some-other-password :withdraw) 10)))
    (is (= "Incorrect password" ((acc 'some-other-password :deposit) 10)))))

(deftest the-cops-are-called
  (let [acc (make-account 100 'secret-password call-cops)]
    (dotimes [_ 6]
      (is (= "Incorrect password" ((acc 'some-other-password :withdraw) 10))))
    (is (zero? @count-cops-called))      
    (is (= "Incorrect password" ((acc 'some-other-password :withdraw) 10)))
    (is (= 1 @count-cops-called))))

(deftest successful-transaction-resets-failure-count
  (let [acc (make-account 100 'secret-password call-cops)]
    (dotimes [_ 6]
      (is (= "Incorrect password" ((acc 'some-other-password :withdraw) 10))))
    (is (= 60 ((acc 'secret-password :withdraw) 40)))
    (is (= "Incorrect password" ((acc 'some-other-password :withdraw) 10)))
    (is (zero? @count-cops-called))))
