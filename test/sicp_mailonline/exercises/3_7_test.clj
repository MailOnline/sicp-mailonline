;; Exercise 3.7

(ns sicp-mailonline.exercises.3-7-test
  (:require [sicp-mailonline.exercises.3-7 :refer :all]
            [sicp-mailonline.exercises.3-3 :refer [make-account]]
            [clojure.test :refer :all]))

(deftest exercise3-7
  (testing "joint account balance"
    (let [peter-acc (make-account 100 'open-sesame)
          paul-acc (make-joint peter-acc 'open-sesame 'rosebud)]

      (is (= 110 ((paul-acc 'rosebud :deposit) 10)))
      (is (= 90 ((paul-acc 'rosebud :withdraw) 20)))

      (is (= 60 ((peter-acc 'open-sesame :withdraw) 30)))
      (is (= 70 ((peter-acc 'open-sesame :deposit) 10)))

      (is (= 50 ((paul-acc 'rosebud :withdraw) 20)))))

  (testing "cannot create joint account with incorrect original password"
    (let [peter-acc (make-account 100 'open-sesame)]
      (is (thrown-with-msg? IllegalArgumentException #"Incorrect password"
                            (make-joint peter-acc 'close-sesame 'rosebud)))))

  (testing "cannot transact on joint account with incorrect password"
    (let [peter-acc (make-account 100 'open-sesame)
          paul-acc (make-joint peter-acc 'open-sesame 'rosebud)]
      (is (= "Incorrect password"
             (paul-acc 'open-sesame :deposit))))))
