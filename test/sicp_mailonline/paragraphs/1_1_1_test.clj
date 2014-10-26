(ns sicp-mailonline.paragraphs.1-1-1-test
  (:require [clojure.test :refer :all]))

(deftest expressions
  (testing "common math"
    (is (= (+ 137 349) 486))
    (is (= (- 1000 334) 666))
    (is (= (* 5 99) 495))
    (is (= (/ 10 5) 2))
    (is (= (+ 2.7 10) 12.7)))
  (testing "prefix notation allow multiple"
    (is (= (+ 21 35 12 7) 75))
    (is (= (* 25 4 12) 1200)))
  (testing "precendce"
    (is (= (+ (* 3 5) (- 10 6)) 19))
    (is (= (+ (* 3 (+ (* 2 4) (+ 3 5))) (+ (- 10 7) 6)) 57)))
  (testing "pretty printing"
    (is (= (+ (* 3
         (+ (* 2 4)
            (+ 3 5)))
      (+ (- 10 7)
          6)) 57))))
