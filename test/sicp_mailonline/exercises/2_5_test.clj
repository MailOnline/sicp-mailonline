; 
; Exercise 2.5
;
(ns sicp-mailonline.exercises.2-5.test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.2-5 :refer :all]))

(deftest mpcon-test
    (testing "mpcon"
      (is (= (mpcon 3 2) 72))))


(deftest mpcar-test
    (testing "mpcar"
      (is (= (mpcar (mpcon 3 2)) 3))))

(run-tests)
