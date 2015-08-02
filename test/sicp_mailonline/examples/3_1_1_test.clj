;; 3.1.1 Local State Variables

(ns sicp-mailonline.examples.3-1-1-test
  (:require [sicp-mailonline.examples.3-1-1 :refer :all]
            [clojure.test :refer :all]))

(deftest example3-1-1
  (testing "make-withdraw"
    (let [w1 (make-withdraw 100)
          w2 (make-withdraw 100)]
      (is (= 50 (w1 50)))
      (is (= 30 (w2 70)))
      (is (thrown? IllegalStateException (w2 40)))
      (is (= 10 (w1 40)))))

  (testing "make-account"
    (let [acc (make-account 100)]
      (is (= 50 ((acc :withdraw) 50)))
      (is (thrown? IllegalStateException ((acc :withdraw) 60)))
      (is (= 90 ((acc :deposit) 40)))
      (is (= 30 ((acc :withdraw) 60))))))
