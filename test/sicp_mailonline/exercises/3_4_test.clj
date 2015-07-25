;
; Exercise 3.4
;
(ns sicp-mailonline.exercises.3-4-test   
	(:require   [clojure.test :refer :all]
	            [sicp-mailonline.exercises.3-4 :refer :all]))

(deftest make-account-test
  (let [acc (make-account 100 'secret-password)]
    (testing "8 incorrect attempts result in the cops"
      (let [
        result  (map #((acc 'some-other-password :deposit) %) (range 1 9))
        expected (concat (repeat 7 "Incorrect password") '("Cops have been called"))]
        (is (= expected result))))))

(run-tests)

