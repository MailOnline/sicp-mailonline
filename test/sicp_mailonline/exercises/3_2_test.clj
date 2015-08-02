;; Exercise 3.2

(ns sicp-mailonline.exercises.3-2-test
  (:require [sicp-mailonline.exercises.3-2 :refer :all]
            [clojure.test :refer :all]))

(defn- sqrt [value]
  (int (Math/sqrt value)))

(deftest exercise3-2
  (testing "make-monitored"
    (let [s (make-monitored sqrt)]
      (is (zero? (s :how-many-calls?)))
      (is (= 10 (s 100)))
      (is (= 1 (s :how-many-calls?)))
      (is (= 7 (s 49)))
      (is (= 2 (s :how-many-calls?)))

      (s :reset-count)
      (is (zero? (s :how-many-calls?)))
      (is (= 10 (s 100)))
      (is (= 1 (s :how-many-calls?))))))
