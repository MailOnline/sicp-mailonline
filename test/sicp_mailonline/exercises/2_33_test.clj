;; Exercise 2.33

(ns sicp-mailonline.exercises.2-33-test
  (:require [sicp-mailonline.exercises.2-33 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const values (list 1 2 3 4))

(deftest exercise2-33
  (testing "map"
    (letfn [(square [n] (* n n))]
      (is (= '(1 4 9 16)
             (map square values)))))

  (testing "append"
    (is (= values
           (append '(1 2) '(3 4)))))

  (testing "length"
    (is (= 4
           (length values)))))
