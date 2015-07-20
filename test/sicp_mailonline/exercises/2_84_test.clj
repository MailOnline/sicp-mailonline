;; Exercise 2.84

(ns sicp-mailonline.exercises.2-84-test
  (:require [sicp-mailonline.exercises.2-84 :refer :all]
            [sicp-mailonline.exercises.2-83 :refer [make-integer
                                                    make-rational
                                                    make-real
                                                    make-complex-from-real-imag]]
            [clojure.test :refer :all]))

(deftest exercise2-84
  (install-arithmetic!)

  (testing "addition of an integer and a rational number"
    (is (= '(rational [7 3])
           (add (make-integer 2)
                (make-rational 1 3))))

    (is (= '(rational [7 3])
           (add (make-rational 1 3)
                (make-integer 2)))))

  (testing "addition of an integer and a real number"
    (is (= '(real 2.25)
           (add (make-integer 2)
                (make-real 0.25))))

    (is (= '(real 2.25)
           (add (make-real 0.25)
                (make-integer 2)))))

  (testing "addition of an integer and a complex number"
    (is (= '(complex (rectangular [45.0 1]))
           (add (make-integer 42)
                (make-complex-from-real-imag 3 1))))

    (is (= '(complex (rectangular [45.0 1]))
           (add (make-complex-from-real-imag 3 1)
                (make-integer 42)))))

  (testing "addition of a rational and a real number"
    (is (= '(real 0.75)
           (add (make-rational 1 2)
                (make-real 0.25))))

    (is (= '(real 0.75)
           (add (make-real 0.25)
                (make-rational 1 2)))))
  
  (testing "addition of a rational and a complex number"
    (is (= '(complex (rectangular [3.5 1]))
           (add (make-rational 1 2)
                (make-complex-from-real-imag 3 1))))

    (is (= '(complex (rectangular [3.5 1]))
           (add (make-complex-from-real-imag 3 1)
                (make-rational 1 2)))))

  (testing "addition of a real and a complex number"
    (is (= '(complex (rectangular [3.5 1]))
           (add (make-real 0.5)
                (make-complex-from-real-imag 3 1))))

    (is (= '(complex (rectangular [3.5 1]))
           (add (make-complex-from-real-imag 3 1)
                (make-real 0.5)))))

  (testing "addition of two integers"
    (is (= '(integer 5)
           (add (make-integer 2)
                (make-integer 3)))))

  (testing "addition of two rational numbers"
    (is (= '(rational [3 4])
           (add (make-rational 1 2)
                (make-rational 1 4)))))

  (testing "addition of two real numbers"
    (is (= '(real 0.75)
           (add (make-real 0.50)
                (make-real 0.25)))))

  (testing "addition of two complex numbers"
    (is (= '(complex (rectangular [5 1]))
           (add (make-complex-from-real-imag 2 0)
                (make-complex-from-real-imag 3 1))))))
