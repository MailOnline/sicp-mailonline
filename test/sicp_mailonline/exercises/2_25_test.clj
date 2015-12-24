; 
; Exercise 2.25
;

(ns sicp-mailonline.exercises.2-25-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-25 :refer :all]))

(deftest list-access-test
  (testing "part 1"
    (is (= (part-1) 7)))

  (testing "part 2"
    (is (= (part-2) 7)))

  (testing "part 3"
    (is (= (part-3) 7))))

(run-tests)



