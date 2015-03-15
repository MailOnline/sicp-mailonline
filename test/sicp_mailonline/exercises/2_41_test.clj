;; Exercise 2.41

(ns sicp-mailonline.exercises.2-41-test
  (:require [sicp-mailonline.exercises.2-41 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-41
  (testing "triples"
    (is (= '()
           (triples 5 5)))
    
    (is (= '((1 2 3))
           (triples 5 6)))

    (is (= '((1 2 4))
           (triples 5 7)))
    
    (is (= '((1 2 5) (1 3 4))
           (triples 5 8)))))
