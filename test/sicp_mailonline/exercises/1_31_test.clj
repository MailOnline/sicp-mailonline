;; Exercise 1.31

(ns sicp-mailonline.exercises.1-31-test
  (:require [sicp-mailonline.exercises.1-31 :refer :all]
            [clojure.test :refer :all]))

(defn- test-factorial [product]
  (testing "factorial"
    (is (= 3628800
           ((make-factorial product) 10)))))

(defn- test-approximating-pi [product]
  (testing "approximations of pi"
    (is (= 36864/11025                        ; 3.343673469
           ((make-approx-pi product 7))))))

(deftest exercise1-31
  (testing "recursive product"
    (test-factorial rproduct)
    (test-approximating-pi rproduct))

  (testing "iterative product"
    (test-factorial iproduct)
    (test-approximating-pi iproduct)))
