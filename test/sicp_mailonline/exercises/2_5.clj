; 
; Exercise 2.5
;
(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest mpcon-test
    (testing "mpcon"
      (is (= (mpcon 3 2) 72))))


(deftest mpcar-test
    (testing "mpcar"
      (is (= (mpcar (mpcon 3 2)) 3))))

(run-all-tests)
