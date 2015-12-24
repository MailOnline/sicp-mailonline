; 
; Exercise 3.1
;
(ns sicp-mailonline.exercises.3-1-test   
	(:require 	[clojure.test :refer :all]
            	[sicp-mailonline.exercises.3-1 :refer :all]))

(deftest make-accumulator-test
	(testing "Persists state"
		(let [A (make-accumulator 5)]
			(is (= 15 (A 10)))
			(is (= 25 (A 10))))))

(run-tests)
