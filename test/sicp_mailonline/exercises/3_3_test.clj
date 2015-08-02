;; Exercise 3.3

(ns sicp-mailonline.exercises.3-3-test
  (:require [sicp-mailonline.exercises.3-3 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise3-3
  (testing "password protected accounts"
    (let [acc (make-account 100 'secret-password)]
      (is (= 60 ((acc 'secret-password :withdraw) 40)))
      (is (= 70 ((acc 'secret-password :deposit) 10)))

      (is (= "Incorrect password" ((acc 'some-other-password :withdraw) 10)))
      (is (= "Incorrect password" ((acc 'some-other-password :deposit) 10))))))
