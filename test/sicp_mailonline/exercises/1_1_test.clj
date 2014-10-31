(ns sicp-mailonline.exercises.1-1-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.exercises.1-1 :refer :all]))

(deftest expected-results
  (testing "I have correctly evaluated the following in my head"
    (is (= (expression-output 0) "10"))
    (is (= (expression-output 1) "12"))
    (is (= (expression-output 2) "8"))
    (is (= (expression-output 3) "6"))
    (is (= (expression-output 4) "#'user/a"))
    (is (= (expression-output 5) "#'user/b"))
    (is (= (expression-output 6) "19"))
    (is (= (expression-output 7) "false"))
    (is (= (expression-output 8) "4"))
    (is (= (expression-output 9) "16"))
    (is (= (expression-output 10) "6"))
    (is (= (expression-output 11) "16"))))
