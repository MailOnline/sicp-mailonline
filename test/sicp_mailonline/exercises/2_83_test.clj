;; Exercise 2.83

(ns sicp-mailonline.exercises.2-83-test
  (:require [sicp-mailonline.exercises.2-83 :refer :all]
            [clojure.test :refer :all]))

(deftest exercise2-83
  (install-arithmetic!)
  
  (testing "an integer can be raised to a rational number"
    (is (= '(rational (42 1))
           (raise (make-integer 42)))))

  (testing "a rational number can be raised to a real number"
    (is (= '(real 42.0)
           (raise (make-rational 42 1))))

    (is (= '(real 0.75)
           (raise (make-rational 3 4)))))
  
  (testing "a real number can be raised to a complex number"
    (is (= '(complex (rectangular (42.0 0)))
           (raise (make-real 42.0))))

    (is (= '(complex (rectangular (0.75 0)))
           (raise (make-real 0.75)))))

  (testing "a complex number cannot be raised"
    (is (thrown? IllegalArgumentException
                 (raise (make-complex-from-real-imag 42.0 0))))))
