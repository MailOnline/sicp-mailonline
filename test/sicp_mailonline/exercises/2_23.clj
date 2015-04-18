; 
; Exercise 2.23
;

(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))

(deftest for-each-test
  (testing "function executed for each element"
    (with-local-vars [data nil]
      (for-each 
        (fn [x] 
        ;  (println x))
          (var-set 
            data 
            (cons x (var-get data))))
        '(1 2 3))  
      (is
        (= (var-get data) '(3 2 1)))))

    (testing "null data"
      (for-each
        (fn [x] (is false))
        nil)))

(run-tests)



