; 
; Paragraph 1.2.2
;
(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest test-count-change
  (testing "Ways to make a dollar are correct"
    (is (= (count-change 100) 292))))

(run-tests)
