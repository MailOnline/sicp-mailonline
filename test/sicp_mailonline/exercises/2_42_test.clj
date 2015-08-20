;
; Exercise 2.42
; 

(ns sicp-mailonline.exercises.2-42-test
  (require [sicp-mailonline.exercises.2-42 :refer :all]
           [clojure.test :refer :all]))


(def expected '(([3 4] [1 3] [4 2] [2 1]) ([2 4] [4 3] [1 2] [3 1])) )


(deftest queens-test
	(testing "Correct result for 1, 3 4 queens")
		(is (= (queens 1) '(([1 1])) ))
		(is (empty? (queens 3)))
		(is (= (queens 4) expected))

	(testing "Correct number of results for 8 and 9 queens")	
		; See https://en.wikipedia.org/wiki/Eight_queens_puzzle	
		(is (= (count (queens 8)) 92)
		(is (= (count (queens 9)) 352))))

(run-tests)
