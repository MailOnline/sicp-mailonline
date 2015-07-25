;
; Exercise 3.7
;
(ns sicp-mailonline.exercises.3-7-test   
  (:require   [clojure.test :refer :all]
              [sicp-mailonline.exercises.3-7 :refer :all]))

(deftest make-joint-test 
  (testing "Both accounts share balance"
    (let [peter-acc (make-account 100 'open-sesame)
          paul-acc (make-joint peter-acc 'open-sesame 'rosebud)]

          (is (= ((peter-acc 'open-sesame :withdraw) 40) 60))
          (is (= ((peter-acc 'open-sesame :withdraw) 40) 20)))))

(run-tests)
