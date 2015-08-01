; 
; Exercise 3.2
;
(ns sicp-mailonline.exercises.3-2-test   
  (:require   [clojure.test :refer :all]
              [sicp-mailonline.exercises.3-2 :refer :all]))

(deftest make-monitored-test
  (testing "Counting number of times called"
    (let [s (make-monitored #(Math/sqrt %))]
       (is (= (s 100) 10.0))
        (is (= (s 4) 2.0))
        (is (= (s :how-many-calls?) 2))))

  (testing "Reset counter works"
   (let [s (make-monitored #(Math/sqrt %))]
      (is (= (s 100) 10.0))
      (is (= (s 4) 2.0))
      (s :reset-count) 
      (is (= (s :how-many-calls?) 0)))))

(run-tests)
