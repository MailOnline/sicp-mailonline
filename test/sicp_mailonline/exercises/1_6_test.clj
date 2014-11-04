(ns sicp-mailonline.exercises.1-6-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-7 :refer :all]
            [sicp-mailonline.exercises.1-6 :refer :all]))

(deftest test-new-if-false
  (testing "Else clause is returned when predicate is false"
    (is (= 5 (new-if (= 2 3) 0 5)))))

(deftest test-new-if-true
  (testing "Then clause is returned when predicate is false"
    (is (= 0 (new-if (= 1 1) 0 5)))))

(deftest test-new-sqrt-iter
  (testing "The new sqrt-iter method works like the original"
    (is (= (sqrt-iter 1.0 9) (new-sqrt-iter 1.0 9)))
    (is (= (sqrt-iter 1.0 2) (new-sqrt-iter 1.0 2)))
    (is (= (sqrt-iter 1.0 169) (new-sqrt-iter 1.0 169)))))
