;; Exercise 2.62

(ns sicp-mailonline.exercises.2-62-test
  (:require [sicp-mailonline.exercises.2-62 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-62
  (testing "union-set"
    (is (empty? (union-set '() '())))

    (is (= '(42)
           (union-set '(42) '())))

    (is (= '(42)
           (union-set '() '(42))))

    (is (= '(42)
           (union-set '(42) '(42))))

    (is (= '(1 2 3 4)
           (union-set '(1 4) '(2 3))))

    (is (= '(1 2 3 4)
           (union-set '(2 3) '(1 4))))))
