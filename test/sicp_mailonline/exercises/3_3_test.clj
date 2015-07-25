;
; Exercise 3.3
;
 (ns sicp-mailonline.exercises.3-3-test   
  (:require   [clojure.test :refer :all]
              [sicp-mailonline.exercises.3-3 :refer :all]))

(deftest make-account-test
  (let [acc (make-account 100 'secret-password)]
    (testing "Make account when password is correct"
      (is (= ((acc 'secret-password :withdraw) 40) 60)))

    (testing "Make account when password is wrong"
      (is (= ((acc 'some-other-password :deposit) 50)) "Incorrect password"))))

(run-tests)


