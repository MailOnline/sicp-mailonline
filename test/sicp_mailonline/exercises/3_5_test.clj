;
; Exercise 3.5
;
(ns sicp-mailonline.exercises.3-5-test   
	(:require   [clojure.test :refer :all]
	            [sicp-mailonline.exercises.3-5 :refer :all]))

(deftest monte-carol-integratio-test
	(testing "Area of unit circle"
		(let [result (estimate-integral (make-circle 1) -1 1 -1 1 100000)]
			(is (< result 3.15))
			(is (> result 3.13)))))

(run-tests)
